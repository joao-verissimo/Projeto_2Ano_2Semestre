package eapli.base.app.HttpServer;

import eapli.base.BoardManagement.application.AddPostItController;
import eapli.base.BoardManagement.application.ShareAShareBoardController;
import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class HttpServerAjaxBoard {
    private static final ShareAShareBoardController shareBoardController = new ShareAShareBoardController();
    private static final AddPostItController postitcontroller = new AddPostItController();
    static private final String BASE_FOLDER="base.app.sharedboardserver/src/main/java/eapli/base/app/HttpServer/www";
    static private ServerSocket sock;

    public static void main(String args[]) throws Exception {
	Socket cliSock;

	if(args.length!=1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
            }
        
        accessesCounter=0;
	try { sock = new ServerSocket(Integer.parseInt(args[0])); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " + args[0]);
            System.exit(1);
            }
	while(true) { 
            cliSock=sock.accept();
            HttpAjaxLoginAndBoardRequest req=new HttpAjaxLoginAndBoardRequest(cliSock, BASE_FOLDER);
            req.start();
            incAccessesCounter();
            }
        } 
	
    
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    private static int accessesCounter;

    private static synchronized void incAccessesCounter() { accessesCounter++; }

        //Should be a responsive table
        public static synchronized String getBoardStadingInHtml(String email) {
            String textHtml = "<hr><ul>";
            String Boards = shareBoardController.findBoardOwned(email);
            String[] BoardsIds = Boards.split(":");
            textHtml = textHtml + "<div style=\"margin-bottom: 20px;\">";

            for (String BoardId : BoardsIds) {
                SharedBoard board = shareBoardController.findBoardById(Long.valueOf(BoardId));
                List<PostIts> postitlist = postitcontroller.findPostItByBoardId(Long.valueOf(BoardId));
                int columns = board.numColumns().numColumns();
                int rows = board.numRows().numRows();
                textHtml = textHtml + "<table style=\"border-collapse: collapse; width: 100%; max-width: 600px; margin-bottom: 20px;\">";
                textHtml = textHtml + "<thead><tr><th colspan=\"" + columns + "\" style=\"background-color: #f2f2f2; text-align: center; padding: 10px;\"></th></tr></thead>";
                textHtml = textHtml + "<tbody>";

                for (int i = 0; i < rows; i++) {
                    textHtml = textHtml + "<tr>";

                    for (int j = 0; j < columns; j++) {
                        int row = i + 1;
                        int column = j + 1;
                        boolean containsPostIt = false;

                        for (PostIts postit : postitlist) {
                            if (postit.numRows().numRows() == row && postit.numColumns().numColumns() == column) {
                                textHtml = textHtml + "<td style=\"border: 1px solid #ddd; padding: 10px; text-align: center; vertical-align: middle;";

                                // Check if the data is a link to an image
                                if (isImageLink(postit.data())) {
                                    textHtml = textHtml + "max-width: 100%; max-height: 100%;";
                                }

                                textHtml = textHtml + "\">";
                                textHtml = textHtml + "<div style=\"color: gray; font-size: smaller;\">" + postit.author().email().toString() + "</div>";

                                // Check if the data is a link to an image
                                if (isImageLink(postit.data())) {
                                    textHtml = textHtml + "<div><img src=\"" + postit.data() + "\" style=\"max-width: 300px; max-height: 300px;\"></div>";
                                } else {
                                    textHtml = textHtml + "<div>" + postit.data() + "</div>";
                                }

                                textHtml = textHtml + "</td>";
                                containsPostIt = true;
                                break;
                            }
                        }

                        if (!containsPostIt) {
                            textHtml = textHtml + "<td style=\"border: 1px solid #ddd; padding: 10px; text-align: center; vertical-align: middle;\">---</td>";
                        }
                    }

                    textHtml = textHtml + "</tr>";
                }

                textHtml = textHtml + "</tbody></table>";
            }

            textHtml = textHtml + "</div></ul>";
            return textHtml;
        }


    // Helper method to check if a given string is a link to an image
    private static boolean isImageLink(String data) {
        // You can implement your own logic here to determine if the string is a link to an image
        // For example, you can check the file extension or use a regular expression
        // This is a basic implementation that checks for common image file extensions
        String[] imageExtensions = { ".jpg", ".jpeg", ".png", ".gif", ".bmp" };
        for (String extension : imageExtensions) {
            if (data.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }


}
