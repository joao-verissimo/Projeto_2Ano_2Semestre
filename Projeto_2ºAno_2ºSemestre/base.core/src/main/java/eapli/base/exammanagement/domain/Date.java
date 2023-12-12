package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Embeddable
public class Date implements ValueObject {

    private String date;

    public Date(String value) {
        if (isValidDate(value)) {
            this.date = value;
        } else {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-dd-mm");
        }
    }

    public Date() {
        this.date = null;
    }

    public String date() {
        return date;
    }

    public void setDate(String date) {
        if (isValidDate(date)) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-dd-mm");
        }
    }

    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
