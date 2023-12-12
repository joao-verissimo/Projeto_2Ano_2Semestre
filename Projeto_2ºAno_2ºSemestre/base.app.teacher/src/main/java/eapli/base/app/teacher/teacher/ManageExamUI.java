package eapli.base.app.teacher.teacher;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.exammanagement.application.CreateExamController;
import eapli.base.exammanagement.application.ExamManagementController;
import eapli.base.exammanagement.application.ExamManagementService;
import eapli.base.exammanagement.application.ListExamsCourseController;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ManageExamUI extends AbstractListUI<Exam> {

    private final ExamManagementService srvc = new ExamManagementService();
    private final StudentRepository studentService = PersistenceContext.repositories().students();
    CreateExamController theController = new CreateExamController();
    ExamManagementController examManagementController = new ExamManagementController();
    Exam exam = null;

    @Override
    protected Iterable<Exam> elements() {
        return null;
    }

    @Override
    protected Visitor<Exam> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return null;
    }

    @Override
    protected String listHeader() {
        return null;
    }

    @Override
    protected String emptyMessage() {
        return null;
    }

    @Override
    protected boolean doShow() {
        final List<Exam> list = new ArrayList<>();
        final Iterable<Exam> iterable = this.theController.listExams();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no registered exams!");
        } else {
            int cont = 1;
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-6s%-10s%-30s%-30s%n", "Nº:", "Title", "Date", "Description");
            for (final Exam exam : iterable) {
                list.add(exam);
                System.out.printf("%-6d%-10s%-30s%-30s%n", cont, exam.getTitle().getValue(), exam.getDate().date(),
                        exam.getHeader().toString());
                cont++;
            }
        }


        final String code = Console.readLine("Enter the exam number: ");
        exam = srvc.findByCode(code);
        if (exam == null) {
            System.out.println("There is no course with that code.");
            return false;
        }
        System.out.println("Exam: " + exam.toString());
        chooseOption();

        return false;
    }


    @Override
    public String headline() {
        return "Manage Exam";
    }

    protected void chooseOption() {
        showOptionsMenu();
        final int option = Console.readOption(1, 5, 0);
        switch (option) {
            case 1:
                // setHeadTeacher();
                break;
            case 2:
                appendStudents();
                break;
            case 3:
                // removeTeacher();
                break;
            case 4:
                //removeStudent();
                break;
            case 5:
                // openCloseEnrollment();
                break;
        }
    }


    private void showOptionsMenu() {
        // System.out.println("1. Set Head Teacher");
        System.out.println("2. Append Students");
        /*
        System.out.println("3. Remove Teacher");
        System.out.println("4. Remove Student");
        System.out.println("5. Open/Close Course Enrollment");

         */
    }

    private void appendStudents() {
        final String studentNumber = Console.readLine("Enter the student email: ");
        final Student student = studentService.findStudentByEmail(studentNumber);
        if (student == null) {
            System.out.println("There is no student with that number.");
            return;
        }
        examManagementController.appendStudents(student, exam);
    }
}
