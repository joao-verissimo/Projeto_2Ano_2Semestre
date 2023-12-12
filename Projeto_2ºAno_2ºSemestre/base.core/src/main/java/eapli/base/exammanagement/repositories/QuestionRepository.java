package eapli.base.exammanagement.repositories;

import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface QuestionRepository extends DomainRepository<Long, Question> {
    Iterable<Question> findAll();

    List<Exam> findByExam(String course);

    Exam findByID(String code);


}
