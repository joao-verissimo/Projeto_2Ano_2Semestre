package eapli.base.studentmanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.coursemanagement.application.CourseManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.usermanagement.domain.BaseRoles;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.usermanagement.domain.BaseRoles.STUDENT;

public class ShowCoursesAvailableController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final CourseManagementService courseSvc = new CourseManagementService();
    private final EnrollStudentService enrSvc = new EnrollStudentService();



    public Iterable<Course> showActiveCourses(){

        authz.ensureAuthenticatedUserHasAnyOf(STUDENT);

        return courseSvc.findAllActive();
    }
    public Iterable<Course> showCoursesEnrolled(){
        authz.ensureAuthenticatedUserHasAnyOf(STUDENT);
        String email = authz.session().get().authenticatedUser().email().toString();
        Student student = enrSvc.studentRepository.findStudentByEmail(email);
       return courseSvc.findEnrollStateCourses(student.getMecanographicNumber());
  
    }

}
