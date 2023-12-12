package eapli.base.BoardManagement.application;

import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
import eapli.base.BoardManagement.domain.*;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class BoardManagementService {
    private final BoardRepository repoB = PersistenceContext.repositories().boardRepository();
    private final PostItRepository repoP = PersistenceContext.repositories().postItRepository();
    private final UserRepository repoU = PersistenceContext.repositories().users();

    public synchronized boolean archiveBoard(SharedBoard board) {
        synchronized (board.getIdBoard()) {
            try {
                board.archive();
                repoB.archiveBoard(board);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public synchronized boolean addPostIt(String email,String data, String rowS,String columnS, String boardId) {
        final SystemUserAuth author = repoU.findUserByEmail(email);
        SharedBoard board = repoB.findBoardById(Long.valueOf(boardId.replaceAll("[^a-zA-Z0-9@:.\n]", "")));
        boolean sameRowColumn = false;
        synchronized (board.getIdBoard()) {
            try {
                //String name = Console.readLine("Works?");
                int row = Integer.parseInt(rowS);
                int column = Integer.parseInt(columnS);
                for (PostIts p : repoP.findPostItByBoardId(board.getIdBoard())) {
                    if (row == p.numRows().numRows() && column == p.numColumns().numColumns()) {
                        sameRowColumn = true;
                        break;
                    }
                }
                if (row > board.numRows().numRows() || column > board.numColumns().numColumns() || sameRowColumn) {
                    throw new Exception();
                }
                PostIts post = new PostIts(1, new NumRows(row), new NumColumns(column), author, data, board);
                repoP.save(post);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public synchronized boolean appendNewUser(String email, String stateId, String sharedBoardId) {
        SystemUserAuth user = repoU.findUserByEmail(email);
        State state = null;
        SharedBoard sharedBoard = repoB.findBoardById(Long.valueOf(sharedBoardId.replaceAll("[^a-zA-Z0-9@:.\n]", "")));
        synchronized (sharedBoard.getIdBoard()) {
            try {
                if (stateId.replaceAll("[^a-zA-Z0-9@:.\n]", "").equalsIgnoreCase("0")) {
                    state = State.WRITE;
                } else {
                    state = State.READ;
                }
                repoB.appendUser(user, state, sharedBoard);
                return true;
            } catch (Exception e){
                System.out.println("Não foi possível completar a ação. Alguém está a alterar esta mesma board de momento.");
                return false;
            }
        }
    }

    /**
     * Modify post it boolean.
     *
     * @param email   the email
     * @param data    the data
     * @param rowS    the row s
     * @param columnS the column s
     * @param boardId the board id
     * @return the boolean
     */
    public synchronized boolean ModifyPostIt(String email,String data, String rowS,String columnS, String boardId){
        final SystemUserAuth author = repoU.findUserByEmail(email);
        SharedBoard board = repoB.findBoardById(Long.valueOf(boardId.replaceAll("[^a-zA-Z0-9@:.\n]", "")));
        boolean sameRowColumn = true;

        synchronized (board.getIdBoard()) {
            try {

                int row = Integer.parseInt(rowS);
                int column = Integer.parseInt(columnS);
                for (PostIts p : repoP.findPostItByBoardId(board.getIdBoard())) {
                    if (row == p.numRows().numRows() && column == p.numColumns().numColumns()) {
                        sameRowColumn = false;
                        break;
                    }
                }

                if (row > board.numRows().numRows() || column > board.numColumns().numColumns() || sameRowColumn) {
                    throw new Exception();
                }

                PostIts previousPost = repoP.getactivepost(column,row);
                double newversion = previousPost.version();
                newversion++;

                PostIts post = new PostIts(newversion, new NumRows(row),new NumColumns(column),author,data,board);

                repoP.alterstate(previousPost);
                repoP.save(post);

                return true;
            } catch (Exception e) {
                return false;
            }
        }

    }

    /**
     * Find board present list.
     *
     * @param email the email
     * @return the list
     */
    public List<SharedBoard> findBoardPresent(String email){
        return repoB.findBoardPresentWrite(email);
    }

    /**
     * Find post its list.
     *
     * @param bordId the bord id
     * @return the list
     */
    public List<PostIts> findPostIts(Long bordId){
        return repoP.findPostItByBoardId(bordId);
    }

    public synchronized boolean undoPostIt(String email, int row, int column, int idBoard) {
        try {
            repoP.undoPostIt(email, row, column, idBoard);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}