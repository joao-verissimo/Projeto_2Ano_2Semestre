package eapli.base.coursemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {

    @Test
    void getValue() {
        Description description = new Description("EAPLI");
        assertEquals("EAPLI",description.getValue());
    }
}