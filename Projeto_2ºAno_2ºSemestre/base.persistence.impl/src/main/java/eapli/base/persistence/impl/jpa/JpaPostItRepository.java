package eapli.base.persistence.impl.jpa;

import domain.model.SystemUserAuth;
import eapli.base.Application;
import eapli.base.BoardManagement.domain.PostItState;
import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.base.BoardManagement.repositories.PostItRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaPostItRepository extends JpaAutoTxRepository<PostIts, Long, Long> implements PostItRepository {

    public JpaPostItRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaPostItRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public List<PostIts> findPostItByBoardId (Long idboard){
        final TypedQuery<PostIts> query = entityManager().createQuery(
                "SELECT p FROM PostIts p WHERE p.sharedBoard.idBoard = :idboard", PostIts.class);
        query.setParameter("idboard", idboard);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void alterstate(PostIts post) {
        entityManager().getTransaction().begin();
        final Query query = entityManager().createQuery(
                "UPDATE PostIts p SET p.postitstate = 1 WHERE p.idPostIts = :idPostIts");
        query.setParameter("idPostIts", post.idPostIts());
        query.executeUpdate();
        entityManager().getTransaction().commit();
    }


    @Override
    public PostIts getactivepost(int numColums, int numRows) {
        final TypedQuery<PostIts> query = entityManager().createQuery(
                "SELECT p FROM PostIts p where p.numColumns.numColumns =: numColums and p.numRows.numRows =: numRows and p.postitstate = 0", PostIts.class);
        query.setParameter("numColums", numColums);
        query.setParameter("numRows", numRows);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void undoPostIt(String email, int row, int column, int idBoard){
        entityManager().getTransaction().begin();
        entityManager().createQuery("DELETE FROM PostIts WHERE numRows = " + row + " AND numColumns = " + column + " AND sharedBoard.idBoard = " + idBoard + " AND postitstate = 0").executeUpdate();
        entityManager().createQuery(
                "UPDATE PostIts SET postitstate = 0 WHERE sharedBoard = " + idBoard + " AND numColumns = " + column + " AND numRows = " + row + " AND version = (SELECT MAX(version) FROM PostIts WHERE sharedBoard = " + idBoard + ")").executeUpdate();
        entityManager().getTransaction().commit();
    }
}