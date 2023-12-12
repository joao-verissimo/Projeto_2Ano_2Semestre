package eapli.base.classmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * The type Duration.
 */
@Embeddable
public class Duration implements ValueObject {

    private static final Pattern VALID_HOUR_REGEX = Pattern.compile("^(?:[01]?\\d|2[0-3])(?::[0-5]\\d){1,2}$");
    private LocalTime initialTime;

    private LocalTime finishTime;

    /**
     * Instantiates a new Duration.
     *
     * @param initialTime the initial time
     * @param finishTime  the finish time
     */
    public Duration(LocalTime initialTime,LocalTime finishTime) {
        Preconditions.nonEmpty(initialTime.toString());
        Preconditions.nonEmpty(finishTime.toString());
        Preconditions.matches(VALID_HOUR_REGEX, initialTime.toString(), "Invalid Hour: " +initialTime.toString());
        Preconditions.matches(VALID_HOUR_REGEX, finishTime.toString(), "Invalid Hour: " +finishTime.toString());
        this.initialTime = initialTime;
        this.finishTime = finishTime;
    }

    /**
     * Gets finish time.
     *
     * @return the finish time
     */
    public LocalTime getFinishTime() {
        return finishTime;
    }

    /**
     * Gets initial time.
     *
     * @return the initial time
     */
    public LocalTime getInitialTime() {
        return initialTime;
    }

    /**
     * Gets duration value.
     *
     * @return the duration value
     */
    public long getDurationValue() {
        return initialTime.until(finishTime, ChronoUnit.MINUTES);
    }


    /**
     * Instantiates a new Duration.
     */
    protected Duration() {
    }
}
