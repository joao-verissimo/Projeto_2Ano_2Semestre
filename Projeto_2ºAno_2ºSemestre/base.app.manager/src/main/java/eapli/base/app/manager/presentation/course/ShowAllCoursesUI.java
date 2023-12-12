package eapli.base.app.manager.presentation.course;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.eventhandler.ListCourseController;

public class ShowAllCoursesUI {

    ListCourseController theController = new ListCourseController();

    public boolean show() {
        System.out.println("Courses:");
        Iterable<Course> courses = theController.listCourses();
        for (Course course : courses) {
            System.out.println(formatCourse(course));
        }
        return true;
    }

    private String formatCourse(Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ").append(course.getCode())
                .append("\nTitle: ").append(course.getTitle())
                .append("\nName: ").append(course.getName())
                .append("\nCapacity: ").append(course.getCapacity().toString());
        return sb.toString();
    }
}
