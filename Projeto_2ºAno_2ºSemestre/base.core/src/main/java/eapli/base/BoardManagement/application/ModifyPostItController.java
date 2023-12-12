package eapli.base.BoardManagement.application;

import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;

/**
 * The type Modify post it controller.
 *
 * @author joaomorais
 */
public class ModifyPostItController {

    private final BoardManagementService svc = new BoardManagementService();

    /**
     * Modify post it boolean.
     *
     * @param email   the email
     * @param data    the data
     * @param row     the row
     * @param column  the column
     * @param boardId the board id
     * @return the boolean
     */
    public synchronized boolean ModifyPostIt (String email,String data, String row,String column, String boardId){
        return svc.ModifyPostIt(email,data,row,column,boardId);
    }


    /**
     * Find board present string.
     *
     * @param email the email
     * @return the string
     */
    public String findBoardPresent(String email){
        String list = "";
        for (SharedBoard sh : svc.findBoardPresent(email)){
            list += sh.getIdBoard().toString()+":";
        }
        return list;
    }


    /**
     * Find post its string.
     *
     * @param boardId the board id
     * @return the string
     */
    public String findPostIts(Long boardId){
        String list = "";
        for (PostIts pst : svc.findPostIts(boardId)){
            list += pst.toString()+":";
        }
        return list;
    }

}
