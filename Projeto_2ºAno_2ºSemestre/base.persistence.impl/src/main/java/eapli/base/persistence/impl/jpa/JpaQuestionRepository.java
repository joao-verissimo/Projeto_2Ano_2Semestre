package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.exammanagement.domain.Exam;
import eapli.base.exammanagement.domain.Question;
import eapli.base.exammanagement.domain.TypeofQuestion;
import eapli.base.exammanagement.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
public class JpaQuestionRepository extends JpaAutoTxRepository<Question, Long, Long> implements QuestionRepository {

    public JpaQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaQuestionRepository(final String puname) { super(puname, Application.settings().getExtendedPersistenceProperties(), "id");}
    @Override
    public List<Question> findAll() {
        return createQuery("SELECT c FROM Question c", Question.class).getResultList();
    }

    @Override
    public List<Exam> findByExam(String examID) {
        String queryString = "SELECT q.exam FROM Question q JOIN q.exam.coursecode c WHERE c.code = :examID";
        TypedQuery<Exam> query = createQuery(queryString, Exam.class);
        query.setParameter("examID", examID);
        return query.getResultList();
    }



    @Override
    public Exam findByID(String code) {
        return null;
    }

}
