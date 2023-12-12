package eapli.base.MeetingManagement.domain;

import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public class TimeMeeting implements ValueObject {
    private final String time;

    public TimeMeeting(String time) {
        try{
            LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid time format. Expected format: hh:mm");
        }
        this.time = time;
    }

    public TimeMeeting() {
        time = null;
    }

    public String timeMeeting() {
        return time;
    }
}