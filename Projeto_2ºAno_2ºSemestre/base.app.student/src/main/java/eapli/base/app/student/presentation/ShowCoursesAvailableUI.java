package eapli.base.app.student.presentation;

import eapli.base.coursemanagement.application.DeactivateActivateCourseController;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.application.ShowCoursesAvailableController;
import eapli.framework.presentation.console.AbstractUI;
;

import java.util.ArrayList;
import java.util.List;

public class ShowCoursesAvailableUI extends AbstractUI {

    private final ShowCoursesAvailableController controller = new ShowCoursesAvailableController();

    @Override
    protected boolean doShow() {
        final List<Course> listActive = new ArrayList<>();
        final List<Course> listEnrolled = new ArrayList<>();
        final Iterable<Course> iterableActive = this.controller.showActiveCourses();
        final Iterable<Course> iterableEnrolled = this.controller.showCoursesEnrolled();
        if (!iterableActive.iterator().hasNext()) {
            System.out.println("There is no active courses");
        } else {
            int cont = 1;
            System.out.println("Courses that can be Enrolled\n");
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
            for (final Course course : iterableActive) {
                listActive.add(course);
                System.out.printf("%-6d%-10s%-30s%-30s%n", cont, course.getName().getValue(), course.getCode().getValue(),
                        course.getTitle().getValue());
                cont++;
            }
            System.out.println("\n");
        }
        if (!iterableEnrolled.iterator().hasNext()){
            System.out.println("There is no courses Enrolled ");
        } else {
            int cont2 = 1;
            System.out.println("Courses Enrolled\n");
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
            for (final Course course : iterableEnrolled) {
                listEnrolled.add(course);
                System.out.printf("%-6d%-10s%-30s%-30s%n",cont2, course.getCode().getValue(), course.getName().getValue(), course.getTitle().getValue());
                cont2++;
            }
            System.out.println("\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return null;
    }
}



