package eapli.base.teachermanagement.domain;

import eapli.base.studentmanagement.domain.TaxPayerNumber;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Acronym.
 */
@Embeddable
public final class Acronym implements Serializable, Comparable<Acronym> {
    private String acronym;

    private static final Pattern VALID_ACRONYM_REGEX = Pattern.compile("^[A-Z]{3}$");

    /**
     * Instantiates a new Acronym.
     *
     * @param acronym the acronym
     */
    public Acronym(String acronym) {
        Preconditions.matches(VALID_ACRONYM_REGEX, acronym, "Invalid Acronym (must have 3 letters and can't be empty): " +acronym);;
        this.acronym = acronym;
    }

    @Override
    public String toString() {
        return acronym;
    }

    /**
     * Instantiates a new Acronym.
     */
    protected Acronym() {

    }

    /**
     * Gets acronym.
     *
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    private boolean isValidAcronym(String acronym) {
        return acronym != null && acronym.matches("^[A-Z]{3}$");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acronym)) return false;
        Acronym acronym1 = (Acronym) o;
        return acronym.equals(acronym1.acronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronym);
    }

    @Override
    public int compareTo(Acronym o) {
        return 0;
    }

    /**
     * Value of acronym.
     *
     * @param acronym the acronym
     * @return the acronym
     */
    public static Acronym valueOf(final String acronym) {
        return new Acronym(acronym);
    }

}
