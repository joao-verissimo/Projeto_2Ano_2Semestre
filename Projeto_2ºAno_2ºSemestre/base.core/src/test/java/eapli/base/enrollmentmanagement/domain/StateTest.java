package eapli.base.enrollmentmanagement.domain;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StateTest {
    @Test
    public void testEnumValues() {
        // Verify that all enum values are present and in the correct order
        State[] values = State.values();
        Assertions.assertEquals(3, values.length);
        Assertions.assertEquals(State.WAITING, values[0]);
        Assertions.assertEquals(State.ACCEPTED, values[1]);
        Assertions.assertEquals(State.DENIED, values[2]);
    }

    @Test
    public void testEnumToString() {
        // Verify the toString() method returns the expected string representation
        Assertions.assertEquals("WAITING", State.WAITING.toString());
        Assertions.assertEquals("ACCEPTED", State.ACCEPTED.toString());
        Assertions.assertEquals("DENIED", State.DENIED.toString());
    }

    @Test
    public void testEnumValueOf() {
        // Verify the valueOf() method returns the correct enum constant
        Assertions.assertEquals(State.WAITING, State.valueOf("WAITING"));
        Assertions.assertEquals(State.ACCEPTED, State.valueOf("ACCEPTED"));
        Assertions.assertEquals(State.DENIED, State.valueOf("DENIED"));
    }
}
