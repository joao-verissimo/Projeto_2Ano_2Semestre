package eapli.base.studentmanagement.application;

import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalContext;

public class NextExamsService {

    ExamRepository examRepository = PersistenceContext.repositories().exams();
    StudentRepository studentRepository = PersistenceContext.repositories().students();

    public Iterable<Exam> nextExams (Student student){
       return studentRepository.nextExams(student);
    }

}
