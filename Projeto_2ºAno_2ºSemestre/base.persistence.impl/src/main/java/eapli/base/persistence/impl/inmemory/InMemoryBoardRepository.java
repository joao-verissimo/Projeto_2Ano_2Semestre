package eapli.base.persistence.impl.inmemory;

import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.domain.State;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryBoardRepository extends InMemoryDomainRepository<SharedBoard,Long> implements BoardRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public boolean createBoard(int rows, int columns, SystemUserAuth owner, State state) {
        return false;
    }

    @Override
    public List<SharedBoard> findBoardOwned(String email) {
        return null;
    }

    @Override
    public List<SharedBoard> findBoardPresentWrite(String email) {
        return null;
    }

    @Override
    public void appendUser(SystemUserAuth user, State state, SharedBoard board) {
    }

    @Override
    public SharedBoard findBoardById(Long id) {
        return null;
    }

    @Override
    public void archiveBoard(SharedBoard board){}
    @Override
    public List<SystemUserAuth> findUsersPresent(Long boardId){
        return null;
    }
}
