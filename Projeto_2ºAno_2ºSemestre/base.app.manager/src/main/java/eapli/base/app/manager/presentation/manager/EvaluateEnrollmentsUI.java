package eapli.base.app.manager.presentation.manager;

import eapli.base.coursemanagement.eventhandler.CourseManagementController;
import eapli.base.enrollmentmanagement.Application.EnrollmentConsulterService;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.domain.State;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The type Evaluate enrollments ui.
 *
 * @author joaomorais
 */
public class EvaluateEnrollmentsUI extends AbstractListUI<Enrollment> {

    /**
     * The Enrollment repository.
     */
    EnrollmentRepository enrollmentRepository = PersistenceContext.repositories().enrollments();

    @Override
    protected Iterable<Enrollment> elements() {
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
        EnrollmentConsulterService controller = new EnrollmentConsulterService();
        CourseManagementController controllercourse = new CourseManagementController();
        Iterable<Enrollment> enrollmentList = controller.listEnrollments();

        System.out.println("Enrollment Requests\n");
        System.out.printf("%-6s%-10s%-30s%-30s%n", "Idº:", "Student", "Course", "State");

        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getState().equals(State.WAITING)) {
                System.out.printf("%-6d%-10s%-30s%-30s%n", enrollment.getId(),
                        enrollment.getStudent().getMecanographicNumber(), enrollment.getCourse().getCode(),
                        enrollment.getState());
            }
        }

        boolean flag = true;
        Enrollment selectedEnrollment = null;

        while (flag) {
            int indexEnrollment = Console.readInteger("Choose the Enrollment index to accept (0 to exit)");
            if (indexEnrollment == 0) {
                return false;
            } else {
                Iterator<Enrollment> iterator = enrollmentList.iterator();
                int currentIndex = 0;
                while (iterator.hasNext()) {
                    currentIndex++;
                    Enrollment enrollment = iterator.next();
                    if (currentIndex == indexEnrollment) {
                        selectedEnrollment = enrollment;
                        break;
                    }
                }

                if (selectedEnrollment != null) {
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }
        }

        try {
            controller.alterState(selectedEnrollment.getStudent(), selectedEnrollment.getCourse());

            List<Student> studentlist = new ArrayList<>();
            studentlist.add(selectedEnrollment.getStudent());
            controllercourse.appendStudent(studentlist,selectedEnrollment.getCourse());
            enrollmentRepository.save(selectedEnrollment);
            System.out.println("Student " + selectedEnrollment.getStudent().getMecanographicNumber()
                    + " was successfully added to the course: " + selectedEnrollment.getCourse().getCode());
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred while evaluating the enrollment: " + e.getMessage());
            return false;
        }
    }

    @Override
    protected Visitor<Enrollment> elementPrinter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elementPrinter'");
    }
}
