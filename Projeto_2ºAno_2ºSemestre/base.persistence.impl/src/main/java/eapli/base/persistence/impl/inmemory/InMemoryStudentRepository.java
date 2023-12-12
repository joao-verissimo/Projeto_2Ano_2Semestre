package eapli.base.persistence.impl.inmemory;

import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryStudentRepository extends InMemoryDomainRepository<Student, Long> implements StudentRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Student> findAllStudents() {
        return null;
    }

    @Override
    public Iterable<Exam> nextExams(Student student) {
        return null;
    }


    public Student findStudentByEmail(String emailAddress) {
        return null;
    }

    @Override
    public void appendCourse(List<Course> course, Student student) {

    }

    @Override
    public Iterable<Exam> showGrades(Student student) {
        return null;
    }
}

