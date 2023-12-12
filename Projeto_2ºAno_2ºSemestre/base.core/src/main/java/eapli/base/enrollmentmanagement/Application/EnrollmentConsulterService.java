package eapli.base.enrollmentmanagement.Application;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;

/**
 * The type Enrollment consulter service.
 *
 * @author joaomorais
 */
public class EnrollmentConsulterService {

    /**
     * The Enrollment repository.
     */
    EnrollmentRepository enrollmentRepository = PersistenceContext.repositories().enrollments();


    /**
     * List enrollments iterable.
     *
     * @return the iterable
     */
    public Iterable<Enrollment> listEnrollments() {
        return enrollmentRepository.findAll();
    }


    /**
     * Alter state enrollment.
     *
     * @param student the student
     * @param course  the course
     * @return the enrollment
     */
    public Enrollment alterState(Student student, Course course) {return enrollmentRepository.alterState(student,course);}


}
