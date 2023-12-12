package domain.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import domain.model.SystemUserAuth;
import eapli.framework.general.domain.model.EmailAddress;

/**
 * User repository.
 *
 * @author nuno on 21/03/16.
 */
public interface UserRepository extends DomainRepository<EmailAddress, SystemUserAuth> {

    /**
     * Returns the currently active/inactive users.
     *
     * @param active
     *            the status we want to look for
     *
     * @return the currently active/inactive users
     */
    Iterable<SystemUserAuth> findByActive(boolean active);

    SystemUserAuth findUserByEmail(String email);
}
