package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryEnrollmentRepository extends InMemoryDomainRepository<Enrollment,Long> implements EnrollmentRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public Iterable<Course> findAllActive() {
        return null;
    }

    @Override
    public Enrollment alterState(Student student,Course course) {return  null;}
}
