package eapli.base.MeetingManagement.repositories;

import eapli.base.MeetingManagement.domain.Meeting;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface MeetingRepository extends DomainRepository<Long, Meeting>{
    long findMaxId();

    void cancelMeeting(long idMeet);

    List<Meeting> userMeetings(String email);

    List<Meeting> allUserMeetings(String email);
}
