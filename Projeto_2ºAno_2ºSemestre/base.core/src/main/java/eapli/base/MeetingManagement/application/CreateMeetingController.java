package eapli.base.MeetingManagement.application;

import application.AuthzRegistry;
import application.UserManagementService;
import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.domain.Duration;
import eapli.base.MeetingManagement.domain.TimeMeeting;
import eapli.base.exammanagement.domain.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Lima
 */
public class CreateMeetingController {
    private CreateMeetingService service;
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public CreateMeetingController(){
        service = new CreateMeetingService();
    }

    public boolean createMeeting(Date date, Duration duration, TimeMeeting timeMeeting, List<String> userList) {
        Iterable<SystemUserAuth> allUsers = userSvc.allUsers();
        List<SystemUserAuth> userAccess = new ArrayList<>();
        for(SystemUserAuth su : allUsers){
            for(String ul : userList){
                if(su.email().toString().equals(ul)){
                    userAccess.add(su);
                }
            }
        }
        return service.createMeeting(date, duration, timeMeeting, userAccess);
    }
}
