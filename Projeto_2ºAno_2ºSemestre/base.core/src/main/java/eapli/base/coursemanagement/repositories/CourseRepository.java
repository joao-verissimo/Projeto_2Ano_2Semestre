package eapli.base.coursemanagement.repositories;

import eapli.base.coursemanagement.domain.Code;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends DomainRepository<Code,Course> {

    Iterable<Course> findAllActive();


    Iterable<Course> findAll();

    Iterable<Course> findEnrollStateCourses(long MechanographicNumber);
    Iterable<Course> findTeachingCourses (String acronym);

    Course findByCode(String code);

    Iterable<Course> findAllInactive();

    void deactivateCourse(Course code);

    void activateCourse(Course code);

    void appendTeacher(Teacher teacher, Course course);

    void appendStudent(List<Student> student, Course course);

    void removeTeacher(Teacher teacher, Course course);
    void removeStudent(Student student, Course course);

    void setHeadTeacher(Teacher teacher, Course course);

    void openEnrollment(Course course);
    void closeEnrollment(Course course);
}