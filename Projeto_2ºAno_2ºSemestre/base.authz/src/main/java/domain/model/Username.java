package domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * A user name. It must not be empty.
 *
 * @author Paulo Gandra Sousa
 */
@Embeddable
@EqualsAndHashCode
public final class Username implements Serializable,Comparable<Username> {

    private static final long serialVersionUID = 1L;

    @Column(name = "username")
    private final String value;

    protected Username() {
        // for ORM
        value = null;
    }

    protected Username(final String username) {
        Preconditions.ensure(StringPredicates.isSingleWord(username),
                "username should neither be null nor empty");
        value = username;
    }

    public static Username valueOf(final String username) {
        return new Username(username);
    }
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(Username other) {
        return this.value.compareTo(other.value);
    }
}

