package eapli.base.BoardManagement.application;

import domain.model.SystemUserAuth;

/**
 * @author Jorge Lima
 */

public class CreateBoardController {
    private CreateBoardService service;

    public CreateBoardController(){
        service = new CreateBoardService();
    }

    public boolean createBoard(int rows, int columns, SystemUserAuth owner) {
        return service.createBoard(rows, columns, owner);
    }
}