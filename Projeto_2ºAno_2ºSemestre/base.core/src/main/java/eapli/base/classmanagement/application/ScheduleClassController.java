package eapli.base.classmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.classmanagement.builder.ClassBuilder;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.Title;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.usermanagement.domain.BaseRoles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * The type Schedule class controller.
 */
public class ScheduleClassController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ScheduleClassService svc = new ScheduleClassService();

    /**
     * Schedule class.
     *
     * @param title        the title
     * @param initialTime  the initial time
     * @param finishTime   the finish time
     * @param dayOfTheWeek the day of the week
     */
    public void scheduleClass(String title, String initialTime, String finishTime,String dayOfTheWeek) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        svc.schedule(title,initialTime,finishTime,dayOfTheWeek);
    }

    /**
     * Show my classes iterable.
     *
     * @return the iterable
     */
    public Iterable<Class> showMyClasses (){
        return svc.showMyClasses();
    }
}
