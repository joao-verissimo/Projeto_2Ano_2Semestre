package eapli.base.studentmanagement.application;

import eapli.base.exammanagement.application.ExamManagementService;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;

import javax.persistence.Persistence;
import java.util.List;

public class ShowGradesController {
    ShowGradesService gradesService = new ShowGradesService();
    EvaluationRepository evaluationRepository = PersistenceContext.repositories().evaluations();
    public Iterable<Exam> listGrades(Student student){
        return gradesService.showGrades(student);
    }

    public List<Evaluation> findById(Long code){
        return evaluationRepository.findById(code);
    }
}