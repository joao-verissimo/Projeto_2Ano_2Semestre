package eapli.base.coursemanagement.eventhandler;

import eapli.base.coursemanagement.domain.*;
//import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class ListCourseController {
    CourseRepository courseRepository = PersistenceContext.repositories().Course();

    public Iterable<Course> listCourses() {
        return courseRepository.findAll();
    }


}

