package eapli.base.exammanagement.application;

import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;

import java.util.List;

public class EvaluationController {
    EvaluationService evaluationService = new EvaluationService();
    public void createEvaluation(Student student, Exam exam, Teacher teacher, int grade){
         evaluationService.createEvaluation(student, exam, teacher, grade);
    }
    public Iterable<Evaluation> findall() {
        return evaluationService.findall();
    }

    public void createEvaluationStudent(Student student, Exam chosenExam, List<Question> list){
        evaluationService.createEvaluationStudent(student,chosenExam,list);
    }
}
