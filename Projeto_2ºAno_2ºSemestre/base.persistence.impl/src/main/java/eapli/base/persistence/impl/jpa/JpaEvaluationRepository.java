package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.exammanagement.domain.Code;
import eapli.base.exammanagement.domain.Evaluation;
import eapli.base.exammanagement.repositories.EvaluationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaEvaluationRepository extends JpaAutoTxRepository<Evaluation, Code,Code> implements EvaluationRepository {
    public JpaEvaluationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaEvaluationRepository(final String puname) { super(puname, Application.settings().getExtendedPersistenceProperties(), "id");}
    @Override
    public List<Evaluation> findAll() {
        return createQuery("SELECT c FROM Evaluation c", Evaluation.class).getResultList();
    }

    @Override
    public List<Evaluation> findById(Long code) {
        String query = "SELECT e FROM Evaluation e WHERE e.student.mecanographicNumber = :code";
        List<Evaluation> result = entityManager()
                .createQuery(query, Evaluation.class)
                .setParameter("code", code)
                .getResultList();
        return result;
    }
    @Override
    public List<Evaluation> findAllStudentsOfACourse(String examID) {
        String query = "SELECT e FROM Evaluation e WHERE e.exam.id = :examID";
        List<Evaluation> result = entityManager()
                .createQuery(query, Evaluation.class)
                .setParameter("examID", examID)
                .getResultList();
        return result;
    }
}
