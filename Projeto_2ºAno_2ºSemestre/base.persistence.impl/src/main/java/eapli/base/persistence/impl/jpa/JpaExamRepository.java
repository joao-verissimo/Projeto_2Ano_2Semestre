package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.repositories.ExamRepository;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.hibernate.sql.Select;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaExamRepository extends JpaAutoTxRepository<Exam,Code,Code> implements ExamRepository {
    public JpaExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExamRepository(final String puname) { super(puname, Application.settings().getExtendedPersistenceProperties(), "id");}

    @Override
    public List<Exam> findAll() {
        return createQuery("SELECT c FROM Exam c", Exam.class).getResultList();
    }

    @Override
    public Optional<Exam> ofIdentity(Code id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Code entityId) {

    }

    @Override
    public List<Exam> findByCourse(String course) {
        List<Exam> all = findAll();
        List<Exam> listCourse = new ArrayList<Exam>();
        for (Exam exam:all) {
            if (exam.getCourse().getCode().toString().equals(course)){
                listCourse.add(exam);
            }
        }
        return listCourse;
    }

    @Override
    public Exam findByCode(String code) {
        List<Exam> list = findAll();
        for (Exam exam : list) {
            if (String.valueOf(exam.getId()).equals(code)) {
                return exam;
            }
        }
        return null;
    }

    @Transactional
    public void appendStudent(Student student, Exam ExamCode){
        ExamCode.appendStudent(student);
        this.repo.save(ExamCode);
    }
}
