package eapli.base.app.manager.presentation.course;

import eapli.base.coursemanagement.application.DeactivateActivateCourseController;
import eapli.base.coursemanagement.domain.Course;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DeactivateCourseUI extends AbstractUI {


    private static final Logger LOGGER = LoggerFactory.getLogger(DeactivateCourseUI.class);

    private final DeactivateActivateCourseController theController = new DeactivateActivateCourseController();

    @Override
    protected boolean doShow() {
        final List<Course> list = new ArrayList<>();
        final Iterable<Course> iterable = this.theController.activeCourses();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered course");
        } else {
            int cont = 1;
            System.out.println("SELECT Course to activate\n");
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
            for (final Course course : iterable) {
                list.add(course);
                System.out.printf("%-6d%-10s%-30s%-30s%n", cont, course.getName().getValue(), course.getCode().getValue(),
                        course.getTitle().getValue());
                cont++;
            }
            final int option = Console.readInteger("Enter course nº to activate or 0 to finish ");
            if (option == 0) {
                System.out.println("No course selected");
            } else {
                try {
                    this.theController.deactivateCourse(list.get(option - 1));
                    System.out.println(list.get(option -1 ).toString());
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Deactivate/Activate Course";
    }
}
