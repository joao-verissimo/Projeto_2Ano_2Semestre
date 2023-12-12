package domain.model;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.persistence.Embeddable;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * A Person's name
 */
@Embeddable
@Value
@Accessors(fluent = true)
public final class Name implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("squid:S4784")
    private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z][a-zA-Z ',.\\-]*$",
            Pattern.CASE_INSENSITIVE);

    private final String fullName;
    private final String shortName;

    protected Name(final String firstName, final String lastName) {
        Preconditions.nonEmpty(firstName, "Full name should neither be null nor empty");
        Preconditions.nonEmpty(lastName, "Short name should neither be null nor empty");
        //Preconditions.matches(VALID_NAME_REGEX, firstName, "Invalid First Name: " + firstName);
        //Preconditions.matches(VALID_NAME_REGEX, lastName, "Invalid Last Name: " + lastName);

        this.fullName = firstName;
        this.shortName = lastName;
    }

    protected Name() {
        // ORM only
        fullName = shortName = "";
    }

    /**
     * builds a Name object
     *
     * @param firstName
     * @param lastName
     *
     * @return a Name
     */
    public static Name valueOf(final String firstName, final String lastName) {
        return new Name(firstName, lastName);
    }

    @Override
    public String toString() {
        return fullName + " " + shortName;
    }
}
