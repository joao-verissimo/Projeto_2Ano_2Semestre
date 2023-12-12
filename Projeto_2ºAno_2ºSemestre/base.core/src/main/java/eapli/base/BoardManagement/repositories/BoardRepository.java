package eapli.base.BoardManagement.repositories;

import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.domain.State;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface BoardRepository extends DomainRepository<Long, SharedBoard> {
    boolean createBoard(int rows, int columns, final SystemUserAuth owner, State state);

    List<SharedBoard> findBoardOwned(String email);

    List<SharedBoard> findBoardPresentWrite(String email);

    void appendUser(SystemUserAuth user, State state, SharedBoard board);

    SharedBoard findBoardById(Long id);

    void archiveBoard(SharedBoard board);

    List<SystemUserAuth> findUsersPresent(Long boardId);
}