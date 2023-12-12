package eapli.base.enrollmentmanagement.Application;

import eapli.base.coursemanagement.domain.*;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.studentmanagement.domain.Student;
import eapli.base.studentmanagement.repositories.StudentRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import application.AuthorizationService;
import application.AuthzRegistry;

/**
 * The type Enrollment service.
 *
 * @author joaomorais
 */
public class EnrollmentService {

    /**
     * The Enrollment repository.
     */
    EnrollmentRepository enrollmentRepository = PersistenceContext.repositories().enrollments();
    /**
     * The Student repository.
     */
    StudentRepository studentRepository = PersistenceContext.repositories().students();


    private final AuthorizationService authorizationService;

    /**
     * Instantiates a new Enrollment service.
     */
    public EnrollmentService() {
       authorizationService = AuthzRegistry.authorizationService();
        authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.STUDENT);
    }


    /**
     * Enroll student boolean.
     *
     * @param course the course
     * @return the boolean
     */
    public boolean enrollStudent(Course course){

        String emailAddress  = authorizationService.session().get().authenticatedUser().email().toString();

        Student student = studentRepository.findStudentByEmail(emailAddress);

        Enrollment newEnrollment = new Enrollment(student,course);
        enrollmentRepository.save(newEnrollment);

        return true;
    }


    public boolean enrollStudentwithstudent(Course course,Student student){

        Enrollment newEnrollment = new Enrollment(student,course);
        enrollmentRepository.save(newEnrollment);

        return true;
    }


    /**
     * List enrollments iterable.
     *
     * @return the iterable
     */
    public Iterable<Enrollment> listEnrollments() {
        return enrollmentRepository.findAll();
    }



}
