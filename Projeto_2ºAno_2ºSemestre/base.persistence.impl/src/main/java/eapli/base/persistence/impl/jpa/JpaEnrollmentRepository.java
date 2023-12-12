package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.enrollmentmanagement.domain.Enrollment;
import eapli.base.enrollmentmanagement.domain.State;
import eapli.base.enrollmentmanagement.repositories.EnrollmentRepository;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;
import java.util.Optional;

class JpaEnrollmentRepository extends JpaAutoTxRepository<Enrollment, Long, Long> implements EnrollmentRepository {

    public JpaEnrollmentRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaEnrollmentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }


    @Override
    public List<Enrollment> findAll() {
        return createQuery("SELECT e FROM Enrollment e", Enrollment.class).getResultList();
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
    public Enrollment alterState(Student student, Course course) {
        List<Enrollment> list = findAll();
        for (Enrollment enrollment : list) {
            if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                enrollment.setState(State.ACCEPTED);
                return enrollment;
            }
        }
        return null;
    }
}

