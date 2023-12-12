package eapli.base.MeetingManagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class MeetingEvaluationController {


    MeetingALRepository meetingaccesslistRepository = PersistenceContext.repositories().meetingAlRepository();

    private final AuthorizationService authorizationService;


    public MeetingEvaluationController() {
        authorizationService = AuthzRegistry.authorizationService();
    }


    public SystemUserAuth getUser(){

        SystemUserAuth user  = authorizationService.session().get().authenticatedUser();

        return user;
    }

    public Iterable<MeetingAccessList> listMeetingAL() {
        return meetingaccesslistRepository.findAll();
    }

    public MeetingAccessList alterStateA(SystemUserAuth user) {return meetingaccesslistRepository.alterStateA(user);}

    public MeetingAccessList alterStateD(SystemUserAuth user) {return meetingaccesslistRepository.alterStateD(user);}


}
