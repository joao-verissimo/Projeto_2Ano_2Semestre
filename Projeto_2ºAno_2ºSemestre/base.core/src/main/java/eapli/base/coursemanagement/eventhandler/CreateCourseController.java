package eapli.base.coursemanagement.eventhandler;

import eapli.base.coursemanagement.domain.Course;
//import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.coursemanagement.domain.*;
import eapli.framework.general.domain.model.Designation;

public class CreateCourseController {

    CourseRepository courseRepository = PersistenceContext.repositories().Course();

    public void createCourse(Name name, Capacity capacity, Description description, Title title, Code code,State active) {
        Course newCourse = new Course(code,name,capacity,description,title,active);
        if (courseRepository.findByCode(code.getValue()) != null){
            System.out.println("Course already exists");
        }
        else{
            courseRepository.save(newCourse);
            System.out.println("Course created successfully.");
        }
    }

    public Iterable<Course> listCourses() {
        return courseRepository.findAll();
    }

}

