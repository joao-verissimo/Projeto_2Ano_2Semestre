package repositores.impl.jpa;

import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
//import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaBaseRepository;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;

@Component
class JpaUserRepository extends JpaBaseRepository<SystemUserAuth, EmailAddress, EmailAddress> implements UserRepository {
    public JpaUserRepository() {
        super("email");
    }

    public Iterable<SystemUserAuth> findByActive(final boolean active) {
        final TypedQuery<SystemUserAuth> query = entityManager().createQuery(
                "SELECT s FROM SystemUser s WHERE s.active = true ", SystemUserAuth.class);
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

