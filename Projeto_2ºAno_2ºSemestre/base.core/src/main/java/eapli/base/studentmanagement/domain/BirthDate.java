package eapli.base.studentmanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * The type Birth date.
 */
@Embeddable
public class BirthDate implements ValueObject {

    private static final Pattern VALID_BIRTH_DATE_REGEX = Pattern.compile("^(0[1-9]|1\\d|2[0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
    private String birthDate;

    /**
     * Instantiates a new Birth date.
     *
     * @param birthDate the birth date
     */
    public BirthDate(String birthDate) {
        Preconditions.nonEmpty(birthDate,"Birth Date can't be empty or null");
        Preconditions.matches(VALID_BIRTH_DATE_REGEX,birthDate, "Invalid Date (must have 'dd/mm/yyyy' format and must be an available date):" +birthDate);
        this.birthDate = birthDate;
    }

    /**
     * Instantiates a new Birth date.
     */
    protected BirthDate() {

    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Value of birth date.
     *
     * @param birthDate the birth date
     * @return the birth date
     */
    public static BirthDate valueOf(final String birthDate) {
        return new BirthDate(birthDate);
    }
}