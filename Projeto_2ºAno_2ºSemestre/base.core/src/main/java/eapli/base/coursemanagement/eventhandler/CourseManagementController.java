package eapli.base.coursemanagement.eventhandler;

import eapli.base.coursemanagement.application.CourseManagementService;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;

import java.util.List;


public class CourseManagementController extends  ListCourseController{
    private final CourseManagementService courseManagementService = new CourseManagementService();

    public Iterable<Course> findAllActive() {
        return courseManagementService.findAllActive();
    }
    public Iterable<Course> findAllInactive() {
        return courseManagementService.findAllInactive();
    }

    public Iterable<Course> findAll() {
        return courseManagementService.findAll();
    }

    public Course findByCode(String code) {
        return courseManagementService.findByCode(code);
    }

    public void appendStudent (List<Student> student, Course course){courseManagementService.appendStudent(student, course);}
}
