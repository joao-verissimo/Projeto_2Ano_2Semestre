package eapli.base.coursemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleTest {

    @Test
    void getValue() {
        Title title = new Title("EAPLI");
        assertEquals("EAPLI",title.getValue());
    }
}