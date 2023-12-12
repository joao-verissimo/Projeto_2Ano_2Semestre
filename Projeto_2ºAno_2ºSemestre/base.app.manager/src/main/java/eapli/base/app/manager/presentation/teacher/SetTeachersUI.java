package eapli.base.app.manager.presentation.teacher;

import eapli.base.coursemanagement.domain.*;
import eapli.base.coursemanagement.eventhandler.CreateCourseController;
import eapli.base.teachermanagement.eventhandler.SetTeacherController;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.sql.SQLOutput;
import java.util.List;

public class SetTeachersUI extends AbstractListUI<Teacher> {

    private final SetTeacherController controller = new SetTeacherController();
    String acronym;
    String code;




    @Override
    protected Iterable<Teacher> elements() {
        return controller.listTeachers();
    }

    @Override
    protected Visitor<Teacher> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return "teacher";
    }

    @Override
    protected String listHeader() {
        return "List of teachers:";
    }

    @Override
    protected String emptyMessage() {
        return "No teachers available";
    }


    @Override
    public String headline() {
        return "Set a teacher to a course";
    }

    public boolean doShow() {
        Iterable<Teacher> teachers = controller.listTeachers();
        if (!teachers.iterator().hasNext()) {
            System.out.println("No teachers in the database.");
        } else {
            System.out.println("List of Teachers:");
            System.out.println("-----------------");
            System.out.printf("%-10s %-20s%n", "Acronym", "User");
            System.out.println("---------------------------");
            for (Teacher teacher : teachers) {
                System.out.printf("%-10s %-20s%n", teacher.getAcronym(), teacher.getUser().name());

            }
            acronym = Console.readLine("Type the teacher's acronym: ");

        }

        Iterable<Course> courses = controller.listCourses();
        if (!courses.iterator().hasNext()) {
            System.out.println("No courses in the database.");
        } else {
            System.out.println("\nList of Courses:");
            System.out.println("----------------");
            System.out.printf("%-10s %-20s %-10s%n", "Code", "Title", "Name");
            System.out.println("---------------------------------------------");
            for (Course course : courses) {
                System.out.printf("%-10s %-20s %-10s%n", course.getCode(), course.getTitle(), course.getName());
            }
            code = Console.readLine("Type the course code to set the teacher: ");

        }

        if (teachers.iterator().hasNext() && courses.iterator().hasNext()) {
           try {
               controller.appendTeacher(acronym, code);
               System.out.println("Teacher " + acronym + " successfully set to Course " + code + ".");
           }catch (Exception e){

                   System.out.println("An error occurred while setting the teacher to the courses, try again");
                   doShow();
               }

        }

        return true;
    }



}

