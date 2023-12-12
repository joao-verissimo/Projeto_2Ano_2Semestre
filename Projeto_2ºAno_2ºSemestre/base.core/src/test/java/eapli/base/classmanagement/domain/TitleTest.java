package eapli.base.classmanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleTest {
    @Test
    public void ensureTitleCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Title(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Title("");
        });
    }

    @Test
    void getTitle() {
        Title actual = new Title("EAPLI");
        Title expected = new Title("EAPLI");
        assertEquals(actual.getTitle(),expected.getTitle());
    }

    @Test
    void valueOf() {
        String expected = "EAPLI";
        Title actual = new Title("EAPLI");
        assertEquals(actual.getTitle(),Title.valueOf(expected).getTitle());
    }
}