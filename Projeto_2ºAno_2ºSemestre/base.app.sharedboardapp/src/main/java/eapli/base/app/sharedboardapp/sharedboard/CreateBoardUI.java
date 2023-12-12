package eapli.base.app.sharedboardapp.sharedboard;

import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

public class CreateBoardUI {

    public String createBoard() {
        String result;
        final String rows = Console.readLine("Introduce the number of rows: ");
        final String columns = Console.readLine("Introduce the number of columns: ");
        result = rows+":"+columns;
        return result;
    }
}
