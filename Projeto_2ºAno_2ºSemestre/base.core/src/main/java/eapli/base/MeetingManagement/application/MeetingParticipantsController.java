package eapli.base.MeetingManagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

/**
 * @author Jorge Lima
 */
public class MeetingParticipantsController {
    MeetingRepository mr = PersistenceContext.repositories().meetingRepository();
    MeetingALRepository malr = PersistenceContext.repositories().meetingAlRepository();
    private final AuthorizationService authorizationService;

    public MeetingParticipantsController(){
        authorizationService = AuthzRegistry.authorizationService();
    }

    public List<Meeting> userMeetings(){
        return mr.allUserMeetings(authorizationService.session().get().authenticatedUser().email().toString());
    }

    public List<MeetingAccessList> meetingParticipants(Meeting meet) {
        return malr.usersState(meet);
    }
}
