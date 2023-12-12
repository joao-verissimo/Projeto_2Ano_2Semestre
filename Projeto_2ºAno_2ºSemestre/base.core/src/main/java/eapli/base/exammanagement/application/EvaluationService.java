package eapli.base.exammanagement.application;

import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;

import java.util.List;

public class EvaluationService {
    EvaluationRepository evaluationRepository = PersistenceContext.repositories().evaluations();

    public Iterable<Evaluation> allEvaluations() {
        return evaluationRepository.findAll();
    }
    /*
   public Evaluation findById(String code) {
        return evaluationRepository.findById(code);
    }


     */
    public void createEvaluation(Student student, Exam exam, Teacher teacher, int grade){
        Evaluation evaluation = new Evaluation(student, exam, teacher, grade);
        evaluationRepository.save(evaluation);}

    public Iterable<Evaluation> findall() {
        return evaluationRepository.findAll();
    }

    public void createEvaluationStudent(Student student, Exam chosenExam, List<Question> list) {
        Evaluation evaluation = new Evaluation(student,chosenExam,list);
        evaluationRepository.save(evaluation);
    }
}
