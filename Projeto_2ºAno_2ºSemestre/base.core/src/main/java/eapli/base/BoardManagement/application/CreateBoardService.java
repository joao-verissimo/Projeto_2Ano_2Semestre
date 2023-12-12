package eapli.base.BoardManagement.application;

import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.domain.State;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 * @author Jorge Lima
 */

public class CreateBoardService {
    BoardRepository br = PersistenceContext.repositories().boardRepository();

    public boolean createBoard(int rows, int columns, final SystemUserAuth owner) {
        return br.createBoard(rows,columns,owner,State.WRITE);
    }
}