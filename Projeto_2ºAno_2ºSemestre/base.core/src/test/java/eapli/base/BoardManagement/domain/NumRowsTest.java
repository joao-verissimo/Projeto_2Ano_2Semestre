package eapli.base.BoardManagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumRowsTest {

    @Test
    void numRows() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NumRows(Integer.parseInt(""));
        });
    }
}