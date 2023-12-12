package eapli.base.BoardManagement.application;

import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ArchiveBoardController {
    private final BoardManagementService svc = new BoardManagementService();

    BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();

    public boolean archiveBoard(SharedBoard board){
        return svc.archiveBoard(board);
    }

    public String findBoardOwned(String email){
        String list = "";
        for (SharedBoard sh : boardRepository.findBoardOwned(email)){
            list += sh.getIdBoard().toString()+":";
        }
        return list;
    }

    public SharedBoard findBoardbyId(Long id){
        return boardRepository.findBoardById(id);
    }

}
