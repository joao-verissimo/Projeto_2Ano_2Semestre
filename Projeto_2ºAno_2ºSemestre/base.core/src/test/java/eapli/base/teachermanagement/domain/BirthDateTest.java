package eapli.base.teachermanagement.domain;

import eapli.base.studentmanagement.domain.BirthDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {

    @Test
    public void ensureBirthDateCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new eapli.base.studentmanagement.domain.BirthDate(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new eapli.base.studentmanagement.domain.BirthDate("21/13/2001");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new eapli.base.studentmanagement.domain.BirthDate("32/13/2001");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new eapli.base.studentmanagement.domain.BirthDate("21/13/20014");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new eapli.base.studentmanagement.domain.BirthDate("");
        });
    }

    @Test
    void getBirthDate() {
        eapli.base.studentmanagement.domain.BirthDate actual = new eapli.base.studentmanagement.domain.BirthDate("21/12/2000");
        eapli.base.studentmanagement.domain.BirthDate expected = new eapli.base.studentmanagement.domain.BirthDate("21/12/2000");
        assertEquals(actual.getBirthDate(),expected.getBirthDate());
    }

    @Test
    void valueOf() {
        String date = "21/12/2000";
        eapli.base.studentmanagement.domain.BirthDate actual = new eapli.base.studentmanagement.domain.BirthDate("21/12/2000");
        assertEquals(actual.getBirthDate(), BirthDate.valueOf(date).getBirthDate());
    }

}