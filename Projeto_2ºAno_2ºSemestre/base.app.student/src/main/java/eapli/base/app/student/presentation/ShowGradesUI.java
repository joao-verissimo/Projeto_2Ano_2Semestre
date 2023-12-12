package eapli.base.app.student.presentation;

import application.AuthorizationService;
import application.AuthzRegistry;
import eapli.base.exammanagement.application.EvaluationController;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.studentmanagement.application.ShowGradesController;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ShowGradesUI extends AbstractUI {

    ShowGradesController gradesController = new ShowGradesController();

    EvaluationController evaluationController = new EvaluationController();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    @Override
    protected boolean doShow() {
        EmailAddress email = authorizationService.session().get().authenticatedUser().email();
        StudentRepository studentRepository = PersistenceContext.repositories().students();
        Student student = studentRepository.findStudentByEmail(email.toString());
        System.out.println("Grades:");
        List<Evaluation> evaluations = gradesController.findById(student.getMecanographicNumber());
        for (Evaluation a : evaluations) {
            System.out.println("Exam:"+a.getExam().getTitle().toString()+"\nGrade:"+a.getGrade()+"\n");
        }
        return true;
    }


    @Override
    public String headline() {
        return "List Grades";
    }
}