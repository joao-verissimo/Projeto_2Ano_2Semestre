package eapli.base.MeetingManagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public class Duration implements ValueObject {
    private final String duration;

    public Duration(String duration) {
        try{
            LocalTime.parse(duration, DateTimeFormatter.ofPattern("HH:mm"));
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid time format. Expected format: hh:mm");
        }
        this.duration = duration;
    }

    public Duration() {
        duration = null;
    }

    public String duration() {
        return duration;
    }
}
