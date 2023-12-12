package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import eapli.base.classmanagement.repositories.ClassRepository;
import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.time.LocalTime;
import java.util.List;

class JpaClassRepository extends JpaAutoTxRepository<Class, Long, Long> implements ClassRepository {

    public JpaClassRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaClassRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<Class> findAllClassesByAcronym(String acronym) {
        final TypedQuery<Class> query = entityManager().createQuery(
                "SELECT c FROM Class c WHERE c.teacher.acronym.acronym = :acronym", Class.class);
        query.setParameter("acronym", acronym);

        return query.getResultList();
    }

    @Override
    public List<Class> findAll(){
        return createQuery("SELECT c FROM Class c",Class.class).getResultList();
    }

    @Override
    public Class findClassById(Long id) {
        return createQuery("SELECT c FROM Class c WHERE c.id = :classId", Class.class)
                .setParameter("classId", id)
                .getSingleResult();
    }


    @Override
    public void setUpdateClass(Long id, Class c, String newInitalTime, String newFinishTime, DayOfTheWeek dayOfTheWeek) {
        c.setDuration(new Duration(LocalTime.parse(newInitalTime),LocalTime.parse(newFinishTime)));
        c.setDayoftheweek(dayOfTheWeek);
        this.repo.save(c);
    }




}
