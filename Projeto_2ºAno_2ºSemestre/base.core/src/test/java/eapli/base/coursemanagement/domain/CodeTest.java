package eapli.base.coursemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeTest {

    @Test
    void getValue() {
        Code code = new Code("EAPLI");
        assertEquals("EAPLI",code.getValue());
    }

    @Test
    void setValueCode() {
        Code code = new Code("EAPLI");
        code.setValueCode("EAPLI2");
        assertEquals("EAPLI2",code.getValue());
    }
}