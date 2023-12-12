package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaMeetingRepository extends JpaAutoTxRepository<Meeting, Long, Long> implements MeetingRepository {
    public JpaMeetingRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaMeetingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public long findMaxId() {
        Meeting a = createQuery("SELECT MAX(m) FROM Meeting m", Meeting.class).getSingleResult();
        try{
            return a.idMeeting() + 1;
        }catch(Exception e){
            return 1;
        }
    }

    @Override
    public List<Meeting> userMeetings(String email){
        String query = "SELECT m FROM Meeting m WHERE m.creator = '" + email + "'";
        List<Meeting> result = entityManager().createQuery(query, Meeting.class).getResultList();
        return result;
    }

    @Override
    public List<Meeting> allUserMeetings(String email){
        String query = "SELECT m FROM MeetingAccessList m WHERE m.user = '" + email + "'";
        List<MeetingAccessList> result = entityManager().createQuery(query, MeetingAccessList.class).getResultList();
        List<Meeting> resultAll = new ArrayList<>();
        List<Meeting> temp;

        for(MeetingAccessList a : result){
            query = "SELECT m FROM Meeting m WHERE m.idMeeting = " + a.meeting().idMeeting();
            temp = entityManager().createQuery(query, Meeting.class).getResultList();
            resultAll.addAll(temp);
        }
        return resultAll;
    }

    @Override
    public void cancelMeeting(long idMeet) {
        entityManager().getTransaction().begin();
        entityManager().createQuery("DELETE FROM MeetingAccessList WHERE meeting = " + idMeet).executeUpdate();
        entityManager().createQuery("DELETE FROM Meeting WHERE idMeeting = " + idMeet).executeUpdate();
        entityManager().getTransaction().commit();
    }
}
