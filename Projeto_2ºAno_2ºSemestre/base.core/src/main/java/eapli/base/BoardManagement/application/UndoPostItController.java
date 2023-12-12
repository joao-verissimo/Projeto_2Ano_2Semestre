package eapli.base.BoardManagement.application;
/**
 * @author Jorge Lima
 */
public class UndoPostItController {
    private final BoardManagementService svc = new BoardManagementService();

    public UndoPostItController() {
    }

    public synchronized boolean undoPostIt (String email, String row, String column, String idBoard){
        return svc.undoPostIt(email, Integer.parseInt(row), Integer.parseInt(column), Integer.parseInt(idBoard.replaceAll("[^a-zA-Z0-9@:.\n]", "")));
    }
}
