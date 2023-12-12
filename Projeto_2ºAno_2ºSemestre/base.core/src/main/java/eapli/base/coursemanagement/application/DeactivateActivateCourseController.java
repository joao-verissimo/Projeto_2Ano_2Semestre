package eapli.base.coursemanagement.application;

import application.AuthorizationService;
import application.AuthzRegistry;
import application.UserManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.BaseRoles;



public class DeactivateActivateCourseController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseManagementService courseSvc = new CourseManagementService();

    public Iterable<Course> activeCourses() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        return courseSvc.findAllActive();
    }
    public Iterable<Course> inactiveCourses() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        return courseSvc.findAllInactive();
    }


    public void deactivateCourse(Course course) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        courseSvc.deactivateCourse(course);
    }

    public void activateCourse(Course course){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        courseSvc.activateCourse(course);
    }
}
