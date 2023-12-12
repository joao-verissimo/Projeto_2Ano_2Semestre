package eapli.base.app.sharedboardapp;

import eapli.base.app.sharedboardapp.sharedboard.*;
import eapli.framework.io.util.Console;

import java.io.*;
import java.net.Socket;


public class TCPClient {
    private static ArchiveBoardUI archiveUi = new ArchiveBoardUI();
    private static AddPostItUI addPostItUi = new AddPostItUI();
    private static ModifyPostItUI ModifyPostItUi = new ModifyPostItUI();
    private static ShareABoardUI shareABoardUI = new ShareABoardUI();
    private static CreateBoardUI createBoardUI = new CreateBoardUI();
    private static UndoPostItUI undoPostItUI = new UndoPostItUI();
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java YourClassName <ip-address> <port>");
            System.exit(1);
        }

        String ipAddress = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            Socket socket = new Socket(ipAddress, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            Login(reader, outputStream);

            Message response = readMessage(inputStream);
            System.out.println("Authentication response: " + response.getData());

            if (response.getCode() == 2) {

                // Handle other menu options
                // Continue until the user chooses to end the session
                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1 - Create a new board");
                    System.out.println("2 - Share a board");
                    System.out.println("3 - Archive a board");
                    System.out.println("4 - Add a post-it to a board");
                    System.out.println("5 - Modify a post-it");
                    System.out.println("6 - Undo a post-it");
                    System.out.println("7 - End session");

                    String option = reader.readLine();
                    switch (option) {
                        case "1":
                            String boardResult = createBoardUI.createBoard();
                            writeMessage(outputStream, 0, 10, 255, 255,boardResult);
                            response = readMessage(inputStream);
                            if (response.getCode() == 2){
                                System.out.println(response.getData());
                            }
                            break;
                        case "2":
                            String board = "";
                            String user = "";
                            writeMessage(outputStream, 0, 20, 255, 255, "msg");
                            response = readMessage(inputStream);
                            if (response.getCode() == 2) {
                                 board = shareABoardUI.board(response.getData());
                                 writeMessage(outputStream, 0, 21, 255, 255, "msg");
                                 response = readMessage(inputStream);
                                 if (response.getCode() == 2){
                                     user = shareABoardUI.users(response.getData());
                                     String state = shareABoardUI.state();
                                     if (state != ""){
                                         String result = board+":"+user+":"+state;
                                         writeMessage(outputStream, 0, 22, 255, 255, result);
                                         if (response.getCode() == 2){
                                             System.out.println(response.getData());
                                         }
                                     }
                                 }
                            }
                            break;
                        case "3":
                            writeMessage(outputStream, 0, 30, 255, 255, "msg");
                            response = readMessage(inputStream);
                            if (response.getCode() == 2) {
                                String id = archiveUi.chooseIdBoard(response.getData());
                                writeMessage(outputStream, 0, 31, 255, 255, id);
                                response = readMessage(inputStream);
                                if (response.getCode() == 2){
                                    System.out.println(response.getData());
                                }
                            }
                            break;
                        case "4":
                            writeMessage(outputStream, 0, 40, 255, 255, "msg1");
                            response = readMessage(inputStream);
                            if (response.getCode() == 2) {
                                String result1 = addPostItUi.addPostIt(response.getData());
                                writeMessage(outputStream, 0,41, 255, 255, result1);
                                response = readMessage(inputStream);
                                if (response.getCode() == 2){
                                    System.out.println(response.getData());
                                }
                            }
                            break;
                        case "5":
                            writeMessage(outputStream, 0, 50, 255, 255, "msg2");
                            response = readMessage(inputStream);
                            if (response.getCode() == 2) {
                                String result2 = ModifyPostItUi.ModifyPostIt(response.getData());
                                writeMessage(outputStream, 0,51 , 255, 255, result2);
                                response = readMessage(inputStream);
                                if (response.getCode() == 2){
                                    System.out.println(response.getData());
                                }
                            }
                            break;
                        case "6":
                            writeMessage(outputStream, 0, 60, 255, 255, "msg3");
                            response = readMessage(inputStream);
                            if (response.getCode() == 2) {
                                String result2 = undoPostItUI.UndoPostIt(response.getData());
                                writeMessage(outputStream, 0,61, 255, 255, result2);
                                response = readMessage(inputStream);
                                if (response.getCode() == 2){
                                    System.out.println(response.getData());
                                }
                            }
                            break;
                        case "7":
                            writeMessage(outputStream, 0, 1, 255, 255, "");
                            return;
                        default:
                            System.out.println("Invalid option");
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void Login(BufferedReader reader, OutputStream outputStream) throws IOException {
        System.out.println("Enter your email: ");
        String email = reader.readLine();

        System.out.println("Enter your password: ");
        String password = reader.readLine();
        String authMessage = email + ":" + password;
        writeMessage(outputStream, 0, 4, 255, 255, authMessage);
    }


    public static void writeMessage(OutputStream outputStream, int version, int code, int D_LENGTH_1, int D_LENGTH_2, String DATA) throws IOException {
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
        System.out.println(version + " " + code + " " + D_LENGTH_1 + " " + D_LENGTH_2 + " " + DATA);
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
        System.out.println(version + " " + code + " " + D_LENGTH_1 + " " + D_LENGTH_2 + " " + DATA);

        return new Message(version, code, D_LENGTH_1, D_LENGTH_2, DATA);
    }
}
