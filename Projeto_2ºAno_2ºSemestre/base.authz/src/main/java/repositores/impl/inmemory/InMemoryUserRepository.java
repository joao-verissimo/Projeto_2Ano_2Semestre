package repositores.impl.inmemory;

import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

/**
 * The in-memory user repository.
 *
 * @author nuno on 20/03/16.
 */
public class InMemoryUserRepository extends InMemoryDomainRepository<SystemUserAuth, EmailAddress>
        implements UserRepository {

    @Override
    public Iterable<SystemUserAuth> findByActive(final boolean active) {
        return null;
    }

    @Override
    public SystemUserAuth findUserByEmail(String email) {
        return null;
    }
}
