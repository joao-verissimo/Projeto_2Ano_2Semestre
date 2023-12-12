package eapli.base.BoardManagement.application;

import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ShareAShareBoardController {

    private final BoardManagementService boardSvc = new BoardManagementService();

    private final BoardRepository repoB = PersistenceContext.repositories().boardRepository();

    private final UserRepository repoU = PersistenceContext.repositories().users();


    public String activeUsers() {
        String list = "";
        for (SystemUserAuth sh : repoU.findByActive(true)){
            list += sh.email().toString()+":";
        }
        return list;
    }


    public String findBoardOwned(String email){
        String list = "";
        for (SharedBoard sh : repoB.findBoardOwned(email)){
            list += sh.getIdBoard().toString()+":";
        }
        return list;
    }

    public boolean appendNewUser(String user, String state, String sharedBoard){
        if (boardSvc.appendNewUser(user, state, sharedBoard)) {
            return true;
        }
        return false;
        }

    public SharedBoard findBoardById(Long id){
        return repoB.findBoardById(id);
    }

}
