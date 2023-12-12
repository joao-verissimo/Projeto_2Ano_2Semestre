package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;
import eapli.base.classmanagement.repositories.ExtraClassRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

class JpaExtraClassRepository extends JpaAutoTxRepository<ExtraClass, Long, Long> implements ExtraClassRepository {

    public JpaExtraClassRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaExtraClassRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public Iterable<ExtraClass> findAllClassesByAcronym(String acronym) {
        final TypedQuery<ExtraClass> query = entityManager().createQuery(
                "SELECT c FROM ExtraClass c WHERE c.teacher.acronym.acronym = :acronym", ExtraClass.class);
        query.setParameter("acronym", acronym);
        return query.getResultList();
    }

    @Override
    public List<ExtraClass> findAll(){
        return createQuery("SELECT c FROM ExtraClass c",ExtraClass.class).getResultList();
    }
}
