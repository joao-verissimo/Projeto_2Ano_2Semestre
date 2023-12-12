package eapli.base.app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import application.AuthzRegistry;
import application.UserSession;
import domain.model.PlainTextEncoder;
import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.application.*;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;


import java.util.Optional;

public class TCPServer {
    private static final ArchiveBoardController archiveController = new ArchiveBoardController();
    private static final AddPostItController addPostController = new AddPostItController();
    private static final ModifyPostItController modifyPostController = new ModifyPostItController();
    private static final ShareAShareBoardController shareBoardController = new ShareAShareBoardController();
    private static final CreateBoardController createBoardController = new CreateBoardController();
    private static final UndoPostItController undoPostItController = new UndoPostItController();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running. Waiting for clients to connect...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                Thread clientThread = new Thread(() -> {
                    try {
                        handleClient(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        Message authRequest = readMessage(inputStream);
        if (authRequest.getCode() != 4) {
            System.out.println("Invalid authentication request");
            return;
        }
        String[] authData = authRequest.getData().split(":");
        String username = authData[0];
        String password = authData[1];
        Optional<UserSession> authenticatedUser = validateUser(username, password.replaceAll("[^a-zA-Z0-9]", ""));
        int code;
        String response;
        if (authenticatedUser.isPresent()) {
            code= 2;
            response = "Success";
            System.out.println("Authentication successful for user: " + username);
        } else {
            code = 3;
            response = "Failure";
            System.out.println("Authentication failed for user: " + username + password);
        }
        writeMessage(outputStream, 0, code, 255, 255, response);


        if (response.equals("Success")) {
            while (true) {
                Message request = readMessage(inputStream);
                // Handle the request
                if (request.getCode() == 1) {
                    System.out.println("Client requested to end the session");
                    break;
                }
                if (request.getCode() == 10){
                    SystemUserAuth owner = AuthzRegistry.authorizationService().session().get().authenticatedUser();
                    String[] message = request.getData().split(":");
                    if (!createBoardController.createBoard(Integer.parseInt(message[0].replaceAll("[^a-zA-Z0-9@:.\n]", "")),Integer.parseInt(message[1].replaceAll("[^a-zA-Z0-9@:.\n]", "")),owner)){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"There was an error creating the board");
                    }else {
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,"Board created with success");
                    }
                }
                if (request.getCode() == 20){
                    String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                    String list = shareBoardController.findBoardOwned(email);
                    if (list.isEmpty()){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"User doesn't own any boards");
                    }else{
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));
                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 21){
                        list = shareBoardController.activeUsers();
                        if (list.isEmpty()){
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"There are no active users to be added.");
                        }else{
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));

                        }
                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 22){
                        String[] message = request.getData().split(":");
                        if(shareBoardController.appendNewUser(message[1],message[2],message[0])){
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,"User added to the board successfully.");
                        }else{
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"It was not possible to add a user to the shared board.");
                        }
                        break;
                    }
                }
                if (request.getCode() == 30){
                    String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                    String list = archiveController.findBoardOwned(email.replaceAll("[^a-zA-Z0-9@:.\n]", ""));
                    if (list.isEmpty()){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"User doesn't own any boards");
                    }else {
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));
                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 31){
                        SharedBoard board = archiveController.findBoardbyId(Long.valueOf(request.getData().replaceAll("[^a-zA-Z0-9@:.\n]", "")));
                        if (archiveController.archiveBoard(board)){
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,"Board was archived with success");
                        }else {
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"Can't archive a board that is already archived");
                        }
                    }
                    break;
                }
                if (request.getCode() == 40){
                    String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                    String list = addPostController.findBoardPresent(email.replaceAll("[^a-zA-Z0-9@:.\n]", ""));
                    if (list.isEmpty()){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"User is not in a board");
                    }else {
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));

                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 41){
                        String[] message = request.getData().split("::");
                        if (addPostController.addPostIt(email,message[0],message[1],message[2],message[3])){
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,"Post-it added with success");
                        }else {
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"It is not possible to add a post-it to the board");
                        }
                    }
                    break;
                }
                if (request.getCode() == 50) {

                    String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                    String list = modifyPostController.findBoardPresent(email);
                    if (list.isEmpty()){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"User is not in a board");
                    }else {
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));

                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 51){
                        String[] message = request.getData().split("::");
                        if (modifyPostController.ModifyPostIt(email, message[0], message[1], message[2], message[3])){
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,"Post-it Modified with success");
                        }else {
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"It is not possible to Modify the post-it");
                        }
                    }
                    break;
                }
                if (request.getCode() == 60) {
                    String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                    String list = modifyPostController.findBoardPresent(email);
                    if (list.isEmpty()){
                        code = 3;
                        writeMessage(outputStream, 0,code, 255, 255,"User is not in a board");
                    }else {
                        code = 2;
                        writeMessage(outputStream, 0,code, 255, 255,list.replaceAll("[^a-zA-Z0-9@:.\n]", ""));
                    }
                    request = readMessage(inputStream);
                    if (request.getCode() == 61){
                        String[] message = request.getData().split("::");
                        if (undoPostItController.undoPostIt(email, message[0], message[1], message[2])){
                            code = 2;
                            writeMessage(outputStream, 0,code, 255, 255,"The undo was successful");
                        }else {
                            code = 3;
                            writeMessage(outputStream, 0,code, 255, 255,"An error has occurred");
                        }
                    }
                    break;
                }
            }
        }
        clientSocket.close();
    }

    private static Optional<UserSession> validateUser(String username, String password) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());
        return AuthzRegistry.authenticationService().authenticate(username, password);
    }

    public static void writeMessage(
            OutputStream outputStream,
            int version,
            int code,
            int D_LENGTH_1,
            int D_LENGTH_2,
            String DATA
    ) throws IOException {
        // Write the version, code, D_LENGTH_1, and D_LENGTH_2 to the output stream
        outputStream.write(version);
        outputStream.write(code);
        outputStream.write(D_LENGTH_1);
        outputStream.write(D_LENGTH_2);

        // Write the DATA field length
        int dataLength = D_LENGTH_1 + 256 * D_LENGTH_2;
        outputStream.write(dataLength);

        // Write the DATA field if it exists
        if (dataLength > 0) {
            outputStream.write(DATA.getBytes());
        }

        // Flush the output stream
        outputStream.flush();
    }

    public static Message readMessage(InputStream inputStream) throws IOException {
        // Read the version, code, D_LENGTH_1, and D_LENGTH_2 from the input stream
        int version = inputStream.read();
        int code = inputStream.read();
        int D_LENGTH_1 = inputStream.read();
        int D_LENGTH_2 = inputStream.read();

        // Read the DATA field length
        int dataLength = inputStream.read();

        // Read the DATA field if it exists
        String DATA = "";
        if (dataLength > 0) {
            byte[] dataBytes = new byte[dataLength];
            int bytesRead = inputStream.read(dataBytes);
            DATA = new String(dataBytes);
        }
        return new Message(version, code, D_LENGTH_1, D_LENGTH_2, DATA);
    }
}
