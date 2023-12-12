package eapli.base.teachermanagement.eventhandler;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.coursemanagement.application.CourseManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.teachermanagement.domain.Teacher;

import static eapli.base.usermanagement.domain.BaseRoles.TEACHER;

public class ShowTeachingCoursesController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ShowTeachingCourseService stSvc = new ShowTeachingCourseService();

    private final CourseManagementService courseSvc = new CourseManagementService();




    public Iterable<Course> showTeachingCourses(){

        authz.ensureAuthenticatedUserHasAnyOf(TEACHER);
        String email = authz.session().get().authenticatedUser().email().toString();
        Teacher teacher = stSvc.teacherRepository.findTeacherByEmail(email);
        return courseSvc.findTeachingCourses(teacher.getAcronym().toString());

    }



}
