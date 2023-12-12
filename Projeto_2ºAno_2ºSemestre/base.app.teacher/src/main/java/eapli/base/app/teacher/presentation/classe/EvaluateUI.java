package eapli.base.app.teacher.presentation.classe;

import eapli.base.exammanagement.application.EvaluationController;
import eapli.base.exammanagement.application.ExamManagementController;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.application.EnrollStudentController;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.base.teachermanagement.eventhandler.SetTeacherController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Scanner;

public class EvaluateUI  extends AbstractUI {
    private final EvaluationController evaluationController;
    private final EnrollStudentController enrollStudentController;

    private final ExamManagementController examManagementController;

    private final SetTeacherController setTeacherController;
    public EvaluateUI (){
        this.setTeacherController = new SetTeacherController();
        this.evaluationController = new EvaluationController();
        this.enrollStudentController = new EnrollStudentController();
        this.examManagementController = new ExamManagementController();
    }

    @Override
    public String headline() {
        return "Create Evaluation";
    }

    @Override
    protected boolean doShow() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student Email:");
        String studentemail = scanner.nextLine();

        System.out.println("Enter exam Code:");
        String examId = scanner.nextLine();

        System.out.println("Enter teacher Acronym:");
        String teacherId = scanner.nextLine();

        System.out.println("Enter grade:");
        int grade = scanner.nextInt();

        Student student = enrollStudentController.searchByEmail(studentemail);
        Exam exam = examManagementController.findByCode(examId);
        Teacher teacher = setTeacherController.findByAcronym(teacherId);

        evaluationController.createEvaluation(student, exam, teacher, grade);

        System.out.println("Evaluation created successfully");
        return true;
    }
}
