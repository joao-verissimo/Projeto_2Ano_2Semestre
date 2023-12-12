package eapli.base.exammanagement.application;

import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ListExamsGradesPerCourseController {

    EvaluationRepository evaluationRepository = PersistenceContext.repositories().evaluations();

    public List GradesPerCourse (String examID){
        return evaluationRepository.findAllStudentsOfACourse(examID);
    }

}
