package eapli.base.teachermanagement.domain;

import eapli.base.classmanagement.domain.DayOfTheWeek;
import eapli.base.classmanagement.domain.Duration;
import org.hibernate.tuple.component.AbstractComponentTuplizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class AcronymTest {

    @Test
    public void ensureAcronymCantBeNullOrEmpty(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Acronym(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Acronym("AA");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Acronym("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Acronym("AAAA");
        });
    }
    @Test
    void valueOf() {
        String acronym = "AAA";
        Acronym actual = new Acronym("AAA");
        assertEquals(actual.getAcronym(),Acronym.valueOf(acronym).getAcronym());
    }

    @Test
    void getAcronym() {
        Acronym actual = new Acronym("TTT");
        Acronym expected = new Acronym("TTT");
        assertEquals(actual.getAcronym(),expected.getAcronym());
    }
}