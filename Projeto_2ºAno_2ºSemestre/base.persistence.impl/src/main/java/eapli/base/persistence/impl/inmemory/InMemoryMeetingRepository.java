package eapli.base.persistence.impl.inmemory;

import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryMeetingRepository extends InMemoryDomainRepository<Meeting,Long> implements MeetingRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public long findMaxId() { return 0; }

    @Override
    public void cancelMeeting(long idMeet) {}

    @Override
    public List<Meeting> userMeetings(String email){ return null;}

    @Override
    public List<Meeting> allUserMeetings(String email){ return null;}
}
