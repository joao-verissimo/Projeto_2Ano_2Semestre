package eapli.base.studentmanagement.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.List;

public interface StudentRepository extends DomainRepository<Long,Student> {

    public Iterable<Student> findAllStudents();

    public Iterable<Exam> nextExams(Student student);

    Student findStudentByEmail(String emailAddress);
    void appendCourse(List<Course> course, Student student);
    public Iterable<Exam> showGrades(Student student);
}
