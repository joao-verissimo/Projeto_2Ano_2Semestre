package eapli.base.app.backoffice.console.presentation.student;

import eapli.base.coursemanagement.domain.*;
import eapli.base.coursemanagement.eventhandler.CreateCourseController;
import eapli.base.coursemanagement.eventhandler.ListCourseController;
import eapli.base.enrollmentmanagement.Application.EnrollmentService;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;
import eapli.framework.io.util.Console;

import java.util.Iterator;


public class RequestEnrollmentUI extends AbstractListUI<Course> {

    private final EnrollmentService controller;

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


        int i=0;

        for (Course course: coursesList) {
            i++;
            System.out.println(i+" - "+ course.toString());

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
        controller.enrollStudent(selectedCourse);
        return true;
    }
    @Override
    protected Visitor<Course> elementPrinter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementPrinter'");
    }

}
