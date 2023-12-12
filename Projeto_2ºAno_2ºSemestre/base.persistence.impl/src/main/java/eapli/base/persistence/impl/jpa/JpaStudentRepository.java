package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.enrollmentmanagement.domain.State;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

class JpaStudentRepository extends JpaAutoTxRepository<Student, Long, Long> implements StudentRepository {

    public JpaStudentRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaStudentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public List<Student> findAllStudents() {
        return createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }


    public List<Exam> nextExams(Student student) {
        return createQuery("SELECT e FROM Exam e JOIN e.Student s WHERE s = :student", Exam.class)
                .setParameter("student", student)
                .getResultList();
    }


    @Override
    public Student findStudentByEmail(String emailAddress) {
        List<Student> list = findAllStudents();
        for (Student student : list) {
            if (student.getUser().email().toString().equals(emailAddress)) {
                return student;
            }
        }
        return null;
    }


    @Transactional
    public void appendCourse(List<Course> course, Student student) {
        student.appendCourse(course);
        this.repo.save(student);
    }

    public List<Exam> showGrades(Student student){
        return createQuery("SELECT e FROM Exam e JOIN e.Student s WHERE s = :student", Exam.class)
                .setParameter("student", student)
                .getResultList();
    }


}
