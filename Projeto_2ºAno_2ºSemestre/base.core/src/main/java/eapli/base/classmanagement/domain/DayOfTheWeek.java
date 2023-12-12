package eapli.base.classmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Iterator;

/**
 * The type Day of the week.
 */
@Embeddable
public class DayOfTheWeek implements ValueObject {

    private String dayoftheweek;

    /**
     * Instantiates a new Day of the week.
     *
     * @param dayoftheweek the dayoftheweek
     */
    public DayOfTheWeek(String dayoftheweek) {
        Preconditions.nonEmpty(dayoftheweek,"Day of the week can't be empty or null");
        this.dayoftheweek = dayoftheweek;
    }

    /**
     * Instantiates a new Day of the week.
     */
    protected DayOfTheWeek() {

    }

    /**
     * Gets dayoftheweek.
     *
     * @return the dayoftheweek
     */
    public String getDayoftheweek() {
        return dayoftheweek;
    }

    /**
     * Value of day of the week.
     *
     * @param dayoftheweek the dayoftheweek
     * @return the day of the week
     */
    public static DayOfTheWeek valueOf(final String dayoftheweek) {
        return new DayOfTheWeek(dayoftheweek);
    }

    /**
     * Sets dayoftheweek.
     *
     * @param dayoftheweek the dayoftheweek
     */
    public void setDayoftheweek(String dayoftheweek) {
        this.dayoftheweek = dayoftheweek;
    }

    @Override
    public String toString() {
        return "DayOfTheWeek{" +
                "dayoftheweek='" + dayoftheweek + '\'' +
                '}';
    }


}

