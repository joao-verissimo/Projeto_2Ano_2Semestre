package eapli.base.MeetingManagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jorge Lima
 */
public class CancelMeetingController {
    MeetingRepository mr = PersistenceContext.repositories().meetingRepository();
    private final AuthorizationService authorizationService;

    public CancelMeetingController(){
        authorizationService = AuthzRegistry.authorizationService();
    }

    public List<Meeting> userMeetings(){
        return mr.userMeetings(authorizationService.session().get().authenticatedUser().email().toString());
    }

    public void cancelMeeting(Meeting meet) {
        mr.cancelMeeting(meet.idMeeting());
    }
}
