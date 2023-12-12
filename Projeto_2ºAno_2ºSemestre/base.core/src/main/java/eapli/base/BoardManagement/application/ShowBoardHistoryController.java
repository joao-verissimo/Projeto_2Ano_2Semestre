package eapli.base.BoardManagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ShowBoardHistoryController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final BoardRepository repoB = PersistenceContext.repositories().boardRepository();
    private final PostItRepository repoP = PersistenceContext.repositories().postItRepository();


    public Iterable<SystemUserAuth> showHistoryBoardUsers(SharedBoard board){
        synchronized (board.getIdBoard()) {
            return repoB.findUsersPresent(board.getIdBoard());
        }
    }

    public Iterable<PostIts> showHistoryBoardPostIt(SharedBoard board){
        synchronized (board.getIdBoard()) {
            return repoP.findPostItByBoardId(board.getIdBoard());
        }
    }

    public Iterable<SharedBoard> findBoardOwned(){
        String email  = authz.session().get().authenticatedUser().email().toString();
        return repoB.findBoardOwned(email);
    }
}
