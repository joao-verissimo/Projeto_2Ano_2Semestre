package eapli.base.app.manager.presentation.student;

import domain.model.Role;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.eventhandler.ListCourseController;
import eapli.base.studentmanagement.application.EnrollStudentController;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnrollStudentUI extends AbstractUI {

    private final ListCourseController theController = new ListCourseController();
    private final EnrollStudentController controller = new EnrollStudentController();
    @Override
    protected boolean doShow() {
        final List<Course> courses = new ArrayList<>();
        boolean show;
        do {
            show = showCourses(courses);
        } while (!show);
        final String path = Console.readLine("Path to file:");
        try {
            this.controller.loadCSV(path,courses.get(0));
        } catch (IOException e) {
            System.out.println("That path is invalid");
        }
        return false;

    }


    private boolean showCourses(final List<Course> courses) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu courseMenu = buildCoursesMenu(courses);
        final MenuRenderer renderer = new VerticalMenuRenderer(courseMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildCoursesMenu(final List<Course> courses) {
        final Menu rolesMenu = new Menu();
        int counter = 0;
        for (final Course course : theController.listCourses()){
            rolesMenu.addItem(MenuItem.of(counter++, course.getName().getValue(), () -> courses.add(course)));
        }
        return rolesMenu;
    }

    @Override
    public String headline() {
        return "Bulk Enrollment";
    }
}
