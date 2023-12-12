package eapli.base.app.manager.presentation.course;

import eapli.base.app.manager.presentation.authz.DeactivateActivateUserUI;
import eapli.base.coursemanagement.application.DeactivateActivateCourseController;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.application.DeactivateActivateUserController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DeactivateActivateCourseUI extends AbstractUI {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeactivateActivateUserUI.class);

    private final DeactivateActivateCourseController theController = new DeactivateActivateCourseController();

    @Override
    protected boolean doShow() {
        final List<Course> listActive = new ArrayList<>();
        final Iterable<Course> iterableInactive = this.theController.inactiveCourses();
        final Iterable<Course> iterableActive = this.theController.activeCourses();
        final List<Course> listInactive = new ArrayList<>();
        final Integer optionAcDea = Console.readInteger("Enter number to choose the action:\n1. Deactivate\n2. Activate");
        switch (optionAcDea) {
            case 1: {
                if (!iterableActive.iterator().hasNext()) {
                    System.out.println("There is no registered course");
                } else {
                    int cont = 1;
                    System.out.println("SELECT Course to deactivate\n");
                    // FIXME use select widget, see, ChangeDishTypeUI
                    System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
                    for (final Course course : iterableActive) {
                        listActive.add(course);
                        System.out.printf("%-6d%-10s%-30s%-30s%n", cont, course.getName().getValue(), course.getCode().getValue(),
                                course.getTitle().getValue());
                        cont++;
                    }
                    final int option = Console.readInteger("Enter course nº to deactivate or 0 to finish ");
                    if (option == 0) {
                        System.out.println("No course selected");
                    } else {
                        try {
                            this.theController.deactivateCourse(listActive.get(option - 1));
                            System.out.println(listActive.get(option -1 ).toString());
                        } catch (IntegrityViolationException | ConcurrencyException ex) {
                            LOGGER.error("Error performing the operation", ex);
                            System.out.println(
                                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                        }
                    }
                    break;
                }
            }
            case 2: {
                if (!iterableInactive.iterator().hasNext()) {
                    System.out.println("There is no registered course");
                } else {
                    int cont = 1;
                    System.out.println("SELECT Course to activate\n");
                    // FIXME use select widget, see, ChangeDishTypeUI
                    System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");
                    for (final Course course : iterableInactive) {
                        listInactive.add(course);
                        System.out.printf("%-6d%-10s%-30s%-30s%n", cont, course.getName().getValue(), course.getCode().getValue(),
                                course.getTitle().getValue());
                        cont++;
                    }
                    final int option = Console.readInteger("Enter course nº to activate or 0 to finish ");
                    if (option == 0) {
                        System.out.println("No course selected");
                    } else {
                        try {
                            this.theController.activateCourse(listInactive.get(option - 1));
                            System.out.println(listInactive.get(option -1 ).toString());
                        } catch (IntegrityViolationException | ConcurrencyException ex) {
                            LOGGER.error("Error performing the operation", ex);
                            System.out.println(
                                    "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                        }
                    }
                    break;
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
