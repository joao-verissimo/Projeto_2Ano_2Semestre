package eapli.base.coursemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapacityTest {

    @Test
    void getValue() {
        Capacity capacity = new Capacity(10);
        assertEquals(10,capacity.getValue());
    }

}