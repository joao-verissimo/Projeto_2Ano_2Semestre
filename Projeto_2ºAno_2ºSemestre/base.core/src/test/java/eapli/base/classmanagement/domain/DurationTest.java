package eapli.base.classmanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DurationTest {

    @Test
    public void ensureDurationCantBeNullOrEmpty(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Duration(null,null);
        });
        Assertions.assertThrows(DateTimeParseException.class, () -> {
            new Duration(LocalTime.parse(""),LocalTime.parse(""));
        });
    }

    @Test
    public void ensureDurationullHasFormat(){
        Assertions.assertThrows(DateTimeParseException.class, () -> {
            new Duration(LocalTime.parse("12:30"),LocalTime.parse("122:30"));
        });
        Assertions.assertThrows(DateTimeParseException.class, () -> {
            new Duration(LocalTime.parse("25:60"),LocalTime.parse("24:30"));
        });
    }

    @Test
    void getFinishTime() {
        Duration actual = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        Duration expeted = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        assertEquals(actual.getFinishTime(),expeted.getFinishTime());
    }

    @Test
    void getInitialTime() {
        Duration actual = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        Duration expeted = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        assertEquals(actual.getInitialTime(),expeted.getInitialTime());
    }

    @Test
    void getDurationValue() {
        Duration actual = new Duration(LocalTime.parse("12:30"),LocalTime.parse("13:30"));
        assertEquals(actual.getDurationValue(),60);
    }
}