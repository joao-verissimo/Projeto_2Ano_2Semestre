package eapli.base.enrollmentmanagement.repositories;

import eapli.base.coursemanagement.domain.Course;
//import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

/**
 * The interface Enrollment repository.
 * @author joaomorais
 */
public interface EnrollmentRepository extends DomainRepository<Long, Enrollment>{
    /**
     * Find by code optional.
     *
     * @param code the code
     * @return the optional
     */
    Optional<Course> findByCode(String code);

    /**
     * Find all active iterable.
     *
     * @return the iterable
     */
    Iterable<Course> findAllActive();

    /**
     * Alter state enrollment.
     *
     * @param student the student
     * @param course  the course
     * @return the enrollment
     */
    Enrollment alterState(Student student,Course course);
}
