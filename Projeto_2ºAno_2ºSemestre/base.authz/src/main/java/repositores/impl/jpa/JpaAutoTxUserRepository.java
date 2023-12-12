package repositores.impl.jpa;

import domain.model.SystemUserAuth;
import eapli.framework.domain.repositories.TransactionalContext;
import domain.repositories.UserRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Map;

public class JpaAutoTxUserRepository extends JpaAutoTxRepository<SystemUserAuth, EmailAddress, EmailAddress> implements UserRepository {
    public JpaAutoTxUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    public JpaAutoTxUserRepository(final String puname, final Map properties) {
        super(puname, properties, "email");
    }

    public Iterable<SystemUserAuth> findByActive(final boolean active) {
        final TypedQuery<SystemUserAuth> query = entityManager().createQuery(
                "SELECT s FROM SystemUserAuth s WHERE s.active = true ", SystemUserAuth.class);
        return query.getResultList();
    }

    @Override
    public SystemUserAuth findUserByEmail(String email) {
        final TypedQuery<SystemUserAuth> query = entityManager().createQuery(
                "SELECT s FROM SystemUserAuth s WHERE s.email.email = :email", SystemUserAuth.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
