package eapli.base.app.teacher.presentation.classe;

import eapli.base.classmanagement.application.ScheduleClassController;
import eapli.base.classmanagement.application.ScheduleExtraClassController;
import eapli.base.studentmanagement.application.EnrollStudentController;
import eapli.base.studentmanagement.application.EnrollStudentService;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExtraClassUI extends AbstractUI {

    private final ScheduleExtraClassController controller = new ScheduleExtraClassController();
    private final EnrollStudentService studentService = new EnrollStudentService();
    @Override
    protected boolean doShow() {
        final List<Student> studentList;
        final String acronym = Console.readLine("Acronym:");
        final String title = Console.readLine("Title:");
        final String initialTime = Console.readLine("Initial time of class:");
        final String finishTime = Console.readLine("Final time of class:");
        boolean show;
        final String date = Console.readLine("Date of the extra class:");
        studentList=addStuden();
        try {
            this.controller.scheduleExtraClass(acronym,title,initialTime,finishTime,date,studentList);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That title is already in use.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Schedule class";
    }


    public List<Student> addStuden(){
        List<Student> studentList = new ArrayList<>();
        boolean addMoreStudents=true;
        do {
            String studentemail = Console.readLine("Enter student email:");
            Student student = studentService.searchByEmail(studentemail);
            if (student != null) {
                studentList.add(student);
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student not found. Please try again.");
            }
            addMoreStudents = Console.readLine("Do you want to add more students? (yes/no)").equalsIgnoreCase("yes");
        } while (addMoreStudents);
        return studentList;
    }
}
