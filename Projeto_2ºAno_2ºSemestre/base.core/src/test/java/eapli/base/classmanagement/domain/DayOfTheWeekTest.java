package eapli.base.classmanagement.domain;

import eapli.base.BoardManagement.domain.NumColumns;
import eapli.base.BoardManagement.domain.NumRows;
import eapli.base.BoardManagement.domain.SharedBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

class DayOfTheWeekTest {

    @Test
    public void ensureDayOfTheWeekCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DayOfTheWeek(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DayOfTheWeek("");
        });
    }

    @Test
    void getDayoftheweek() {
        DayOfTheWeek actual = new DayOfTheWeek("MONDAY");
        DayOfTheWeek expeted = new DayOfTheWeek("MONDAY");
        assertEquals(actual.getDayoftheweek(),expeted.getDayoftheweek());
    }

    @Test
    void valueOf() {
        String expected = "TUESDAY";
        DayOfTheWeek actual = new DayOfTheWeek("TUESDAY");
        assertEquals(actual.getDayoftheweek(),DayOfTheWeek.valueOf(expected).getDayoftheweek());
    }

    @Test
    void setDayoftheweek() {
        String expected = "TUESDAY";
        DayOfTheWeek actual = new DayOfTheWeek("TUESDAY");
        DayOfTheWeek expectedV = new DayOfTheWeek("FRIDAY");
        expectedV.setDayoftheweek(expected);
        assertEquals(actual.getDayoftheweek(),expectedV.getDayoftheweek());
    }
}