package eapli.base.studentmanagement.application;

import eapli.base.exammanagement.domain.Exam;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;

public class ShowGradesService {

    StudentRepository studentRepository = PersistenceContext.repositories().students();
    public Iterable<Exam> showGrades (Student student){
        return studentRepository.showGrades(student);
    }
}