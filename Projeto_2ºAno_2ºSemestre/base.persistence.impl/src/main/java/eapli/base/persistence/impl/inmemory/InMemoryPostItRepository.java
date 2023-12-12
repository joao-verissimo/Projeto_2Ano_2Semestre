package eapli.base.persistence.impl.inmemory;

import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryPostItRepository extends InMemoryDomainRepository<PostIts,Long> implements PostItRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<PostIts> findPostItByBoardId (Long idboard){
        return null;
    }

    @Override

    public void alterstate(PostIts post) {
    }

    @Override
    public PostIts getactivepost(int numColums, int numRows) {
        return null;
    }

    @Override
    public void undoPostIt(String email, int row, int column, int idBoard){ }
}
