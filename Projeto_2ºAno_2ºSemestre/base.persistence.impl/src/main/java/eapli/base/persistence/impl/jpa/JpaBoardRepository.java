package eapli.base.persistence.impl.jpa;

import domain.model.SystemUserAuth;
import eapli.base.Application;
import eapli.base.BoardManagement.domain.*;
import eapli.base.BoardManagement.repositories.BoardRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaBoardRepository extends JpaAutoTxRepository<SharedBoard, Long, Long> implements BoardRepository{
    public JpaBoardRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaBoardRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Transactional
    public void appendUser(SystemUserAuth user, State state, SharedBoard board){
        board.appendUser(user,state);
        this.repo.save(board);
    }

    @Override
    public boolean createBoard(int rows, int columns, final SystemUserAuth owner, State state) {
        SharedBoard sb = new SharedBoard(new NumRows(rows), new NumColumns(columns), owner);
        try{
            appendUser(owner,state,sb);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<SharedBoard> findBoardOwned(String email) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s WHERE s.admin.email.email = :email", SharedBoard.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    /*@Override
    public List<SharedBoard> findBoardPresentWrite(String email) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT DISTINCT s FROM SharedBoard s JOIN s.map sm " +
                        "WHERE KEY(sm).email.email = :email AND VALUE(sm) = 'WRITE'",
                SharedBoard.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

     */


    @Override
    public List<SharedBoard> findBoardPresentWrite(String email) {
        String nativeQuery = "SELECT DISTINCT s.* FROM SHAREDBOARD s JOIN SHAREDBOARD_MAP sm ON sm.MAP_KEY = :email AND sm.STATE = 0 and s.IDBOARD = sm.SHAREDBOARD_IDBOARD WHERE s.ARCHIVED = false";
        List<SharedBoard> result = entityManager().createNativeQuery(nativeQuery, SharedBoard.class).setParameter("email", email).getResultList();
        return result;
    }

    @Override
    public SharedBoard findBoardById(Long id) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s WHERE s.idBoard = :idboard", SharedBoard.class);
        query.setParameter("idboard", id);
        return query.getSingleResult();
    }
    @Override
    @Transactional
    public void archiveBoard(SharedBoard board) {
        entityManager().getTransaction().begin();
        final Query query = entityManager().createQuery(
                "UPDATE SharedBoard b SET b.archived = true WHERE b.id = :boardId");
        query.setParameter("boardId",board.getIdBoard());
        query.executeUpdate();
        entityManager().getTransaction().commit();
    }
    /*@Override
    public List<SystemUserAuth> findUsersPresent(Long boardId){
        String nativeQuery = "SELECT DISTINCT s.*FROM SYSTEMUSER s JOIN SHAREDBOARD_MAP sm ON s.EMAIL = sm.MAP_KEY WHERE sm.SHAREDBOARD_IDBOARD = :boardid;";
        List<SystemUserAuth> result = entityManager().createNativeQuery(nativeQuery, SharedBoard.class).setParameter("boardid", boardId).getResultList();
        return result;
    }

     */
    @Override
    public List<SystemUserAuth> findUsersPresent(Long idboard){
        String nativeQuery = "SELECT DISTINCT s.* FROM SYSTEMUSER s JOIN SHAREDBOARD_MAP sm ON s.EMAIL = sm.MAP_KEY WHERE sm.SHAREDBOARD_IDBOARD = :idboard";
        List<SystemUserAuth> result = entityManager().createNativeQuery(nativeQuery, SystemUserAuth.class).setParameter("idboard",idboard).getResultList();
        return result;
    }
}
