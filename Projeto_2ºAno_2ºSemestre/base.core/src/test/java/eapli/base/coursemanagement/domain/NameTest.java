package eapli.base.coursemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void getValue() {
        Name name = new Name("EAPLI");
        assertEquals("EAPLI",name.getValue());
    }
}