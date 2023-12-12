package eapli.base.persistence.impl.inmemory;

import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryExamRepository extends InMemoryDomainRepository<Exam, Code> implements ExamRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<Exam> findByCourse(String course) {
        return null;
    }

    @Override
    public Exam findByCode(String code) {
        return null;
    }

    @Override
    public void appendStudent(Student student, Exam ExamCode) {

    }
}
