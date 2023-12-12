package eapli.base.MeetingManagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.domain.Duration;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.TimeMeeting;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.MeetingManagement.repositories.MeetingRepository;
import eapli.base.exammanagement.domain.Date;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Jorge Lima
 */

public class CreateMeetingService {
    MeetingRepository mr = PersistenceContext.repositories().meetingRepository();
    MeetingALRepository macr = PersistenceContext.repositories().meetingAlRepository();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    public boolean createMeeting(Date date, Duration duration, TimeMeeting timeMeeting, List<SystemUserAuth> userList) {
        Meeting meeting = new Meeting(mr.findMaxId(), duration, timeMeeting, date, authorizationService.session().get().authenticatedUser());
        return macr.verifyAndNotify(userList, meeting);
    }
}
