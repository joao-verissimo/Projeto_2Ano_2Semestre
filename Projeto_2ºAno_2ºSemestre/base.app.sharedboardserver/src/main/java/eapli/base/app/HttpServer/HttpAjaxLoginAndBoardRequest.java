package eapli.base.app.HttpServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

import application.AuthzRegistry;
import application.UserSession;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import domain.model.PlainTextEncoder;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;


public class HttpAjaxLoginAndBoardRequest extends Thread {
    String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;
    String username;
    UserSession userSession;

    public HttpAjaxLoginAndBoardRequest(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        // Create data input and output streams for the socket
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }
        try {
            // Read the HTTP request from the input stream
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();

            // Handle different types of requests
            if (request.getMethod().equals("GET")) {

                    String fullname = baseFolder + "/";
                    if (request.getURI().equals("/")) {
                        fullname = fullname + "index.html";
                    } else {
                        fullname = fullname + request.getURI();
                    }
                    // Serve static files
                    if (response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        // File not found
                        response.setContentFromString("<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
             else if (request.getMethod().equals("POST")) {
                Gson gson = new Gson();
                String requestBody = request.getContentAsString();
                if (request.getURI().equals("/board")) {
                    System.out.println(request.getContentAsString());
                    username = request.getContentAsString().replaceAll("username=","").replaceAll("%40","@");
                    response.setContentFromString(HttpServerAjaxBoard.getBoardStadingInHtml(username), "text/html");
                    response.setResponseStatus("200 Ok");
                }
                // Process login request

                if(request.getURI().equals("/login")){
                if (requestBody != null && !requestBody.isEmpty()) {
                    JsonObject jsonObject = gson.fromJson(requestBody, JsonObject.class);
                    username = jsonObject.get("username").getAsString();
                    String password = jsonObject.get("password").getAsString();
                    System.out.println(username + " " + password);
                    if (authenticateUser(username, password).isPresent()) {
                        // Login successful
                        System.out.println("Login successful");
                        response.setResponseStatus("200");
                        response.setContent("LoggedIn","text/html");
                        response.send(outS);
                        return;
                        // Add code for handling the "boards" request
                    }
                }
                // Login failed
                response.setResponseStatus("401 Unauthorized");
                response.send(outS);
                return;
            } }else {
                // Method not allowed
                response.setContentFromString("<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                        "text/html");
                response.setResponseStatus("405 Method Not Allowed");
            }

            response.send(outS);
        } catch (IOException ex) {
            System.out.println("Thread error when reading request");
        }

        try {
            // Close the socket
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }

    private static Optional<UserSession> authenticateUser(String username, String password) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());
        return AuthzRegistry.authenticationService().authenticate(username, password);
    }
}
