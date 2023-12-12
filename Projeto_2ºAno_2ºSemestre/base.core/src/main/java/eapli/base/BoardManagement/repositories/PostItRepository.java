package eapli.base.BoardManagement.repositories;

import eapli.base.BoardManagement.domain.PostIts;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface PostItRepository extends DomainRepository<Long, PostIts> {

    List<PostIts> findPostItByBoardId (Long idboard);

    void alterstate(PostIts post);

    PostIts getactivepost(int numColums, int numRows);

    void undoPostIt(String email, int row, int column, int idBoard);
}
