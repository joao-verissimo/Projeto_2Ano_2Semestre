package application;

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eapli.framework.general.domain.model.EmailAddress;
import domain.model.SystemUserAuth;
import domain.repositories.UserRepository;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 * User Management Service. Provides the typical application use cases for
 * managing {@link SystemUserAuth}, e.g., adding, deactivating, listing, searching.
 *
 * @author Paulo Gandra de Sousa
 */
@Component
public class UserManagementService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final PasswordPolicy policy;

    /**
     *
     * @param userRepo
     * @param encoder
     * @param policy
     */
    @Autowired
    public UserManagementService(final UserRepository userRepo, final PasswordPolicy policy,
                                 final PasswordEncoder encoder) {
        userRepository = userRepo;
        this.policy = policy;
        this.encoder = encoder;
    }

    /**
     * Registers a new user in the system allowing to specify when the user account
     * was created.
     *
     * @param email
     * @param rawPassword
     * @param fullName
     * @param shortName
     * @param roles
     * @param createdOn
     * @return the new user
     */
    @Transactional
    public SystemUserAuth registerNewUser(final String email, final String rawPassword, final String fullName,
                                          final String shortName, final Set<Role> roles, final Calendar createdOn) {
        final var userBuilder = new SystemUserBuilder(policy, encoder);
        userBuilder.with(email, rawPassword, fullName, shortName).createdOn(createdOn).withRoles(roles);
        final var newUser = userBuilder.build();
        return userRepository.save(newUser);
    }

    /**
     * Registers a new user in the system.
     *
     * @param email
     * @param rawPassword
     * @param fullName
     * @param shortName
     * @param email
     * @param roles
     * @return the new user
     */
    @Transactional
    public SystemUserAuth registerNewUser(final String email, final String rawPassword, final String fullName,
                                          final String shortName, final Set<Role> roles) {
        return registerNewUser(email, rawPassword, fullName, shortName,roles, CurrentTimeCalendars.now());
    }

    /**
     * Registers a new user in the system. Mostly useful for two-step
     * signup/registration process where the domain objects were already created by
     * another process, e.g., signup.
     *
     * @param password
     * @param name
     * @param email
     * @param roles
     * @return the enw user
     */
    @Transactional
    public SystemUserAuth registerUser(final EmailAddress email, final Password password, final Name name,
                                       final Set<Role> roles) {
        final var userBuilder = new SystemUserBuilder(policy, encoder);
        userBuilder.with(email, password, name).withRoles(roles);
        final var newUser = userBuilder.build();
        return userRepository.save(newUser);
    }

    /**
     *
     * @return all active users
     */
    public Iterable<SystemUserAuth> activeUsers() {
        return userRepository.findByActive(true);
    }

    /**
     *
     * @return all deactivated users
     */

    public Iterable<SystemUserAuth> deactivedUsers() {
        return userRepository.findByActive(false);
    }
    /**
     *
     * @return all users no matter their status
     */
    public Iterable<SystemUserAuth> allUsers() {
        return userRepository.findAll();
    }

    /**
     * Looks up a user by its username.
     *
     * @param id
     * @return an Optional which value is the user with the desired identify. an
     *         empty Optional if there is no user with that username
     */
    public Optional<SystemUserAuth> userOfIdentity(final EmailAddress id) {
        return userRepository.ofIdentity(id);
    }

    /**
     * Deactivates a user. Client code must not reference the input parameter after
     * calling this method and must use the return object instead.
     *
     * @param user
     * @return the updated user.
     */
    @Transactional
    public SystemUserAuth deactivateUser(final SystemUserAuth user) {
        user.deactivate(CurrentTimeCalendars.now());
        return userRepository.save(user);
    }
    @Transactional
    public SystemUserAuth activateUser(final SystemUserAuth user) {
        user.activate(CurrentTimeCalendars.now());
        return userRepository.save(user);
    }


}
