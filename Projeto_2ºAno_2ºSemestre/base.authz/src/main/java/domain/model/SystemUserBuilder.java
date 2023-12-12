package domain.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import application.PasswordPolicy;
import eapli.framework.validations.Preconditions;

/**
 * A factory for User entities. It helps construct the object and enforces the
 * password policies and encoding.
 *
 * <p>
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface; it acts as a Builder (GoF). For a class such as {@link SystemUserAuth} there is not really
 * a need for a builder
 * and a simple factory or even the constructor would suffice.
 */
public class SystemUserBuilder implements DomainFactory<SystemUserAuth> {

    private static final Logger LOGGER = LogManager.getLogger(SystemUserBuilder.class);

    private EmailAddress email;
    private Password password;
    private Name name;
    private Calendar createdOn;
    private final RoleSetAuth roles;

    private final PasswordPolicy policy;
    private final PasswordEncoder encoder;

    public SystemUserBuilder(final PasswordPolicy policy, final PasswordEncoder encoder) {
        this.policy = policy;
        this.encoder = encoder;
        roles = new RoleSetAuth();
    }

    /**
     * Helper for the most common and mandatory properties of a SystemUser
     *
     * @param email
     * @param password
     * @param fullName
     * @param shortName
     * @return this builder
     */
    public SystemUserBuilder with(final String email, final String password, final String fullName, final String shortName) {
        withEmail(email);
        withPassword(password);
        withName(fullName, shortName);
        return this;
    }

    /**
     * Helper for the most common and mandatory properties of a SystemUser. Note
     * that {@code password} is assumed to be already validated and encoded.
     *
     * @param password
     * @param name
     * @param email
     * @return this builder
     */
    public SystemUserBuilder with(final EmailAddress email, final Password password, final Name name) {
        withEmail(email);
        withPassword(password);
        withName(name);
        return this;
    }

    /**
     * Sets the password of the user <strong>performing</strong> policy
     * enforcement and encoding. If the password does not meet the requirements
     * of the policy, an {@code IllegalArgumentException} is thrown.
     *
     * @param rawPassword
     * @throws IllegalArgumentException
     * @return this builder
     */
    public SystemUserBuilder withPassword(final String rawPassword) {
        password = Password.encodedAndValid(rawPassword, policy, encoder)
                .orElseThrow(IllegalArgumentException::new);
        return this;
    }

    /**
     * Sets the password of the user. This method is mostly to be used to
     * support the registration process where a password has already been
     * validated and encoded.
     *
     * @param password
     * @return this builder
     */
    public SystemUserBuilder withPassword(final Password password) {
        Preconditions.nonNull(password);
        this.password = password;
        return this;
    }

    public SystemUserBuilder withName(final String firstName, final String lastName) {
        name = new Name(firstName, lastName);
        return this;
    }

    public SystemUserBuilder withName(final Name name) {
        this.name = name;
        return this;
    }

    public SystemUserBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public SystemUserBuilder withEmail(final EmailAddress email) {
        this.email = email;
        return this;
    }

    public SystemUserBuilder withRoles(final Role... onlyWithThis) {
        for (final Role each : onlyWithThis) {
            roles.add(new RoleAssignmentAuth(each));
        }
        return this;
    }

    public SystemUserBuilder withRole(final RoleAssignmentAuth role) {
        roles.add(role);
        return this;
    }

    public SystemUserBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemUserBuilder withRoles(final Set<Role> someRoles) {
        List<RoleAssignmentAuth> theRoles;
        if (createdOn == null) {
            theRoles = someRoles.stream().map(RoleAssignmentAuth::new).collect(Collectors.toList());
        } else {
            theRoles = someRoles.stream().map(rt -> new RoleAssignmentAuth(rt, createdOn))
                    .collect(Collectors.toList());
        }
        roles.addAll(theRoles);
        return this;
    }

    public SystemUserBuilder withRoles(final RoleSetAuth roles) {
        this.roles.addAll(roles);
        return this;
    }

    @Override
    public SystemUserAuth build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        SystemUserAuth user;
        if (createdOn != null) {

            user = new SystemUserAuth(email, password, name, roles, createdOn);
        } else {
            user = new SystemUserAuth(email, password, name, roles);
        }
        if (LOGGER.isDebugEnabled()) {
            final String roleLog = roles.roleTypes().toString();
            LOGGER.debug("Creating new user [{}] {} ({} {}) with roles {}", user, email, name,
                     roleLog);
        }
        return user;
    }
}

