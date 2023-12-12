package eapli.base.app.teacher.presentation.courses;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.teachermanagement.eventhandler.ShowTeachingCoursesController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ShowTeachingCoursesUI extends AbstractUI {



    private final ShowTeachingCoursesController controller = new ShowTeachingCoursesController();


    @Override
    protected boolean doShow() {

        final List<Course> listTeaching = new ArrayList<>();
        final Iterable<Course> iterableTeaching = this.controller.showTeachingCourses();
        if (!iterableTeaching.iterator().hasNext()) {
            System.out.println("There is no teaching courses");
        } else {
            int cont = 1;
            System.out.println("Teaching Courses\n");
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
            for (final Course course : iterableTeaching) {
                listTeaching.add(course);
                System.out.printf("%-6d%-10s%-30s%-30s%n", cont, course.getName().getValue(), course.getCode().getValue(),
                        course.getTitle().getValue());
                cont++;
            }
            System.out.println("\n");


        }
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
