package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.usermanagement.domain.BaseRoles;

import java.util.List;

public class ScheduleExtraClassController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ScheduleExtraClassService svc = new ScheduleExtraClassService();

    public void scheduleExtraClass(String acronym, String title, String initialTime, String finishTime, String newdate, List<Student> extra_class_access_list) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        svc.schedule(acronym,title,initialTime,finishTime,newdate,extra_class_access_list);
        }

}
