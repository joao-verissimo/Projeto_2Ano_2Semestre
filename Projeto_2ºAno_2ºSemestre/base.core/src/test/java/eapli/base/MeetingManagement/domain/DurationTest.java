package eapli.base.MeetingManagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationTest {

    @Test
    void duration() {
        Duration a = new Duration("10:30");
        assertEquals(a.duration(), "10:30");
    }

    @Test
    public void ensureDurationCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Duration(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Duration("");
        });
    }

    @Test
    public void ensureDurationCantBeWrongFormat(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Duration("100:30");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Duration("10h30m");
        });
    }
}