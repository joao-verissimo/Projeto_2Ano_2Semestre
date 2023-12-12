package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.domain.Code;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.eventhandler.ListCourseController;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.teachermanagement.domain.Teacher;

import java.util.List;


public class CourseManagementService{
    CourseRepository courseRepository = PersistenceContext.repositories().Course();
    ListCourseController listCourseController = new ListCourseController();
    public Iterable<Course> findAllActive() {
        return courseRepository.findAllActive();
    }
    public Iterable<Course> findAllInactive() {
        return courseRepository.findAllInactive();
    }
    public Iterable<Course> findEnrollStateCourses(long MechanographicNumber){
        return courseRepository.findEnrollStateCourses (MechanographicNumber);
    }
    public Iterable<Course> findTeachingCourses (String acronym){
        return courseRepository.findTeachingCourses(acronym);
    }

    public Iterable<Course> findAll() {
        return listCourseController.listCourses();
    }

    public void deactivateCourse (Course course){
        courseRepository.deactivateCourse(course);
    }

    public void activateCourse (Course course){
        courseRepository.activateCourse(course);
    }


    public Course findByCode(String code) {
        return courseRepository.findByCode(code);
    }

    public void appendTeacher(Teacher teacher, Course course){
        courseRepository.appendTeacher(teacher, course);
    }
    public void appendStudent(List<Student> students, Course course){
        courseRepository.appendStudent(students, course);
    }
    public void removeTeacher(Teacher teacher, Course course){
        courseRepository.removeTeacher(teacher, course);
    }

    public void removeStudent(Student student, Course course){
        courseRepository.removeStudent(student, course);
    }

    public void setHeadTeacher(Teacher teacher, Course course){
        courseRepository.setHeadTeacher(teacher, course);
    }

    public void openEnrollment(Course course) {

    }
    public void closeEnrollment(Course course) {
    }
}
