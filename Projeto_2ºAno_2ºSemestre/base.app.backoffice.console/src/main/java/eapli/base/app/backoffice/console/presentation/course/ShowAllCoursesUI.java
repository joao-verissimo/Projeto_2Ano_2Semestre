package eapli.base.app.backoffice.console.presentation.course;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.eventhandler.ListCourseController;

public class ShowAllCoursesUI {

    ListCourseController theController = new ListCourseController();

    public boolean  show() {
        System.out.println("Courses:");
        Iterable<Course> courses = theController.listCourses();
        for (Course c: courses) {
            System.out.println(c.toString());

        }
        return true;
    }
}
