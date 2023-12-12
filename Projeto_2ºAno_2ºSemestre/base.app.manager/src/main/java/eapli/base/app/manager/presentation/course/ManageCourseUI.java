package eapli.base.app.manager.presentation.course;

import eapli.base.coursemanagement.application.CourseManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.eventhandler.SetTeacherManagementService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ManageCourseUI extends AbstractListUI<Course> {
    private final CourseManagementService srvc = new CourseManagementService();
    private final SetTeacherManagementService teacherService = new SetTeacherManagementService();
    //private final StudentManagementService studentService = new StudentManagementService();
    Course course= null;



    @Override
    protected Iterable<Course> elements() {
        return null;
    }

    @Override
    protected Visitor<Course> elementPrinter() {
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
        final String    code = Console.readLine("Enter the course code: ");
        course = srvc.findByCode(code);
        if (course == null) {
            System.out.println("There is no course with that code.");
            return false;
        }
        System.out.println("Course: " + course.toString());
        chooseOption();

        return false;
    }

    @Override
    public String headline() {
        return "Manage Course";
    }
    protected void chooseOption() {
        showOptionsMenu();
        final int option = Console.readOption(1, 5, 0);
        switch (option) {
            case 1:
                setHeadTeacher();
                break;
            case 2:
                //appendStudents();
                break;
            case 3:
                removeTeacher();
                break;
            case 4:
                //removeStudent();
                break;
            case 5:
                openCloseEnrollment();
                break;
        }
    }

    private void openCloseEnrollment() {
        final String option = Console.readLine("Open or Close? (O/C): ");
        if (option.equals("O")) {
            srvc.openEnrollment(course);
        } else if (option.equals("C")) {
            srvc.closeEnrollment(course);
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void showOptionsMenu() {
        System.out.println("1. Set Head Teacher");
        System.out.println("2. Append Students");
        System.out.println("3. Remove Teacher");
        System.out.println("4. Remove Student");
        System.out.println("5. Open/Close Course Enrollment");
    }

    private void setHeadTeacher() {
        final String teacherNumber = Console.readLine("Enter the teacher Acronym: ");
        final Teacher teacher = teacherService.findByAcronym(teacherNumber);
        if (teacher == null) {
            System.out.println("There is no teacher with that number.");
            return;
        }
        srvc.setHeadTeacher(teacher, course);
    }
    /*private void appendStudents() {
        final String studentNumber = Console.readLine("Enter the student number: ");
        final Student student = studentService.findById(studentNumber);
        if (student == null) {
            System.out.println("There is no student with that number.");
            return;
        }
        srvc.appendStudent(student, course);
    }*/

    private void removeTeacher() {
        final String teacherNumber = Console.readLine("Enter the teacher Acronym: ");
        final Teacher teacher = teacherService.findByAcronym(teacherNumber);
        if (teacher == null) {
            System.out.println("There is no teacher with that number.");
            return;
        }
        srvc.removeTeacher(teacher, course);
    }

    /*private void removeStudent() {
        final String studentNumber = Console.readLine("Enter the student number: ");
        final Student student = studentService.findById(studentNumber);
        if (student == null) {
            System.out.println("There is no student with that number.");
            return;
        }
        srvc.removeStudent(student, course);
    }*/
}


