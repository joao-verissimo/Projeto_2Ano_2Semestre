package eapli.base.exammanagement.repositories;

import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.domain.Exam;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;


public interface EvaluationRepository extends DomainRepository<Code,Evaluation> {
    Iterable<Evaluation> findAll();
    List<Evaluation> findById(Long code);

    List<Evaluation> findAllStudentsOfACourse(String examID);
}
