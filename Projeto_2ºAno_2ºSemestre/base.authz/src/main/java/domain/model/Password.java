package domain.model;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import domain.model.SystemUserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import eapli.framework.domain.model.ValueObject;
import application.PasswordPolicy;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

/**
 * A password of a user. Password policy and encoding is done outside of this
 * class by {@link SystemUserBuilder} and {@link PasswordEncoder}.
 * <p>
 * <b>IMPORTANT</b>: passwords should never be stored in plain format
 *
 * @author Paulo Gandra Sousa
 */
@Embeddable
@EqualsAndHashCode
public final class Password implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "password")
    private final String value;

    protected Password() {
        // for ORM only
        value = null;
    }

    /* package */ Password(final String password) {
        Preconditions.nonNull(password);
        value = password;
    }

    /**
     * Constructs an encoded password ensuring the raw password adheres to the
     * password policy.
     *
     * @param rawPassword
     * @param policy
     * @param encoder
     *
     * @return the new Password or an empty Optional if the passwords does not
     *         satisfies the password policy
     */
    public static Optional<Password> encodedAndValid(final String rawPassword,
                                                                                                       final PasswordPolicy policy,
                                                                                                       final PasswordEncoder encoder) {
        Preconditions.noneNull(rawPassword, policy, encoder);

        if (policy.isSatisfiedBy(rawPassword)) {
            return Optional.of(new Password(encoder.encode(rawPassword)));
        }
        return Optional.empty();
    }

    /**
     * Let's not return the password by mistake.
     */
    @Override
    public String toString() {
        return "************";
    }

    /**
     * For supporting Spring Security UserDetails
     */
    /* package */String value() {
        return value;
    }
}
