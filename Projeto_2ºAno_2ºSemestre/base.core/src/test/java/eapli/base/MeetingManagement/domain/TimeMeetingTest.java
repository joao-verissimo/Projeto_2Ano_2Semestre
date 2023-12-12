package eapli.base.MeetingManagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeMeetingTest {

    @Test
    void timeMeeting() {
        TimeMeeting a = new TimeMeeting("10:30");
        assertEquals(a.timeMeeting(), "10:30");
    }

    @Test
    public void ensureTimeMeetingCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TimeMeeting(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TimeMeeting("");
        });
    }

    @Test
    public void ensureTimeMeetingCantBeWrongFormat(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TimeMeeting("100:30");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TimeMeeting("10h30m");
        });
    }
}