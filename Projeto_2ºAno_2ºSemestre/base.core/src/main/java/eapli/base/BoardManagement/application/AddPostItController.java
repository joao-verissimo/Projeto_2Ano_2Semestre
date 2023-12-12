package eapli.base.BoardManagement.application;

import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class AddPostItController {
    private final BoardManagementService svc = new BoardManagementService();
    private final BoardRepository repoB = PersistenceContext.repositories().boardRepository();

    private final PostItRepository repoP = PersistenceContext.repositories().postItRepository();

    public synchronized boolean addPostIt (String email,String data, String row,String column, String boardId){
        return svc.addPostIt(email,data,row,column,boardId);
    }


    public String findBoardPresent(String email){
        String list = "";
        for (SharedBoard sh : repoB.findBoardPresentWrite(email)){
            list += sh.getIdBoard().toString()+":";
        }
        return list;
    }

    public List<PostIts> findPostItByBoardId (long boardid){
        return repoP.findPostItByBoardId(boardid);
    }
}

