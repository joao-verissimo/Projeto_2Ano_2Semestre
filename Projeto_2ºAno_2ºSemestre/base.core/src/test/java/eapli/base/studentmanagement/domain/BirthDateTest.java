package eapli.base.studentmanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {

    @Test
    public void ensureBirthDateCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BirthDate(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BirthDate("21/13/2001");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BirthDate("32/13/2001");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BirthDate("21/13/20014");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BirthDate("");
        });
    }

    @Test
    void getBirthDate() {
        BirthDate actual = new BirthDate("21/12/2000");
        BirthDate expected = new BirthDate("21/12/2000");
        assertEquals(actual.getBirthDate(),expected.getBirthDate());
    }

    @Test
    void valueOf() {
        String date = "21/12/2000";
        BirthDate actual = new BirthDate("21/12/2000");
        assertEquals(actual.getBirthDate(),BirthDate.valueOf(date).getBirthDate());
    }
}