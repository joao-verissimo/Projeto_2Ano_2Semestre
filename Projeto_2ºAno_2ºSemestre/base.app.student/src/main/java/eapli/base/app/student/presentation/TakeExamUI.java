package eapli.base.app.student.presentation;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.exammanagement.application.EvaluationController;
import eapli.base.exammanagement.application.ExamManagementController;
import eapli.base.exammanagement.domain.CorrectAnswer;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.application.NextExamsController;
import eapli.base.studentmanagement.application.ShowGradesController;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeExamUI extends AbstractUI {
    NextExamsController nextExamsController = new NextExamsController();
    EvaluationController evaluationController = new EvaluationController();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();


    @Override
    protected boolean doShow() {
        EmailAddress email = authorizationService.session().get().authenticatedUser().email();
        StudentRepository studentRepository = PersistenceContext.repositories().students();
        Student student = studentRepository.findStudentByEmail(email.toString());
        Iterable<Exam> exams = nextExamsController.nextExams(student);
        displayAvailableExams(exams);

        System.out.println("Choose exam to take");
        List<Exam> examList = new ArrayList<>();
        int index = 1;

        for (Exam exam : exams) {
            System.out.println(index + ". " + exam.getId());
            examList.add(exam);
            index++;
        }


        System.out.println();
        int examNumber = chooseExam();

        System.out.println();

        if (examNumber > 0 && examNumber <= examList.size()) {
            Exam chosenExam = examList.get(examNumber - 1);
            System.out.println("You selected: " + chosenExam.getId());

            answerQuestions(chosenExam,student);
            evaluationController.createEvaluationStudent(student,chosenExam,chosenExam.getQuestions());
        } else {
            System.out.println("Invalid exam number");
        }
        return true;
    }


    @Override
    public String headline() {
        return "Take Exam";
    }


    private void displayAvailableExams(Iterable<Exam> exams) {
        System.out.println("Available Exams:");
        int index = 1;
        for (Exam exam : exams) {
            System.out.println(index + ". " + exam.getId());
            index++;
        }
        System.out.println();
    }
    private int chooseExam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the exam number: ");
        return scanner.nextInt();
    }

    private void answerQuestions(Exam exam, Student student) {
        Scanner scanner = new Scanner(System.in);

        for (Question question : exam.getQuestions()) {
            System.out.println(question.getValue());
            String answer = scanner.next();
            question.setAnswergiven(answer);
        }
    }
}