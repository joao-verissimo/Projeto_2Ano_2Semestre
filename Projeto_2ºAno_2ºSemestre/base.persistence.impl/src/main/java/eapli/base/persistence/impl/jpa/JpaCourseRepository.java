package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Code;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.hibernate.type.StringType;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

class JpaCourseRepository extends JpaAutoTxRepository<Course, Long, Long> implements CourseRepository {

    public JpaCourseRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCourseRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("eapli.base");
    EntityManager manager = factory.createEntityManager();
    @Override
    public List<Course> findAll() {
        return createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Optional<Course> ofIdentity(Code id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Course> findAllActive() {
        return createQuery("SELECT c FROM Course c WHERE c.state = 0", Course.class).getResultList();
    }

    @Override

    public Iterable<Course> findEnrollStateCourses(long mechanographicNumber) {
        String querry = "SELECT c FROM Course c JOIN c.Student s WHERE s.mecanographicNumber = :studentId";
        return createQuery(querry,Course.class).setParameter("studentId", mechanographicNumber).getResultList();
    }
    public Iterable<Course> findTeachingCourses (String acronym) {
        String query = "SELECT c FROM Course c JOIN c.teacher t WHERE t.acronym.acronym = :Teacher_acronym";
        return createQuery(query, Course.class)
                .setParameter("Teacher_acronym", acronym)
                .getResultList();
    }

    @Override
    public Course findByCode(String code) {
        List<Course> list = findAll();
        for (Course course : list) {
            if (course.getCode().getValue().equals(code)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Iterable<Course> findAllInactive() {
        return createQuery("SELECT c FROM Course c WHERE c.state = 1", Course.class).getResultList();
    }

    @Override
    public void deleteOfIdentity(Code entityId) {

    }

    @Transactional
    public void deactivateCourse(Course course) {
        course.toogleStateDeactivate();
        this.repo.save(course);
    }

    @Transactional
    public void activateCourse(Course course) {
        course.toogleStateActivate();
        this.repo.save(course);
    }

    @Transactional
    public void appendTeacher(Teacher teacher, Course course){
          course.appendTeacher(teacher);
          this.repo.save(course);
    }

    @Transactional
    public void appendStudent(List<Student>student, Course course) {
        course.appendStudent(student);
        this.repo.save(course);
    }

    @Transactional
    public void removeTeacher(Teacher teacher, Course course) {
        course.removeTeacher(teacher);
        this.repo.save(course);
    }

    @Transactional
    public void removeStudent(Student student, Course course) {
        course.removeStudent(student);
        this.repo.save(course);
    }

    @Transactional
    public void setHeadTeacher(Teacher teacher, Course course) {
        course.setHeadTeacher(teacher);
        this.repo.save(course);
    }


    @Transactional
    public void openEnrollment(Course course) {
        course.openEnrollment();
        this.repo.save(course);
    }

    @Transactional
    public void closeEnrollment(Course course) {
        course.closeEnrollment();
        this.repo.save(course);
    }
}
