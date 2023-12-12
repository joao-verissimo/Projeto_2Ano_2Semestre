package eapli.base.exammanagement.repositories;

import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExamRepository extends DomainRepository<Code,Exam> {

    Iterable<Exam> findAll();

    List<Exam> findByCourse(String course);

    Exam findByCode(String code);

    void appendStudent(Student student, Exam examCode);
}
