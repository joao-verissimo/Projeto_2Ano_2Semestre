package eapli.base.app.student.presentation;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.eventhandler.CreateCourseController;
import eapli.base.coursemanagement.eventhandler.ListCourseController;
import eapli.base.enrollmentmanagement.Application.EnrollmentService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.Iterator;


/**
 * The type Request enrollment ui.
 *
 * @author joaomorais
 */
public class RequestEnrollmentUI extends AbstractListUI<Course> {

    private final EnrollmentService controller;

    /**
     * Instantiates a new Request enrollment ui.
     */
    public RequestEnrollmentUI() {
        this.controller = new EnrollmentService();
    }

    @Override
    protected Iterable<Course> elements() {
        return null;
    }

    @Override
    protected String elementName() {
        return "Enrollment Requests";
    }

    @Override
    protected String listHeader() {
        return "List of requests:";
    }

    @Override
    protected String emptyMessage() {
        return "Request failed";
    }


    @Override
    public String headline() {
        return "Request Enrollment";
    }


    public boolean doShow() {
        EnrollmentService controller = new EnrollmentService();
        CreateCourseController controllerCourse = new CreateCourseController();
        ListCourseController theController = new ListCourseController();
        Iterable<Course> coursesList = theController.listCourses();

        System.out.println("Courses Available\n");
        System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Name", "Code", "Title");

        int i = 0;

        for (Course course : coursesList) {
            i++;
            System.out.printf("%-6d%-10s%-30s%-30s%n", i, course.getName().getValue(), course.getCode().getValue(),
                    course.getTitle().getValue());

        }

        boolean flag = true;
        Course selectedCourse = null;

        while (flag) {
            int indexCourse = Console.readInteger("Choose the Course index (0 to exit)");
            if (indexCourse == 0) {
                return false;
            } else {
                Iterator<Course> iterator = coursesList.iterator();
                int currentIndex = 0;
                while (iterator.hasNext()) {
                    currentIndex++;
                    Course course = iterator.next();
                    if (currentIndex == indexCourse) {
                        selectedCourse = course;
                        break;
                    }
                }

                if (selectedCourse != null) {
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }
        }

        try {
            controller.enrollStudent(selectedCourse);
            System.out.println("Request was made successfully");
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred while making the request: " + e.getMessage());
            return false;
        }
    }

    @Override
    protected Visitor<Course> elementPrinter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementPrinter'");
    }
}
