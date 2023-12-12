package eapli.base.BoardManagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumColumnsTest {

    @Test
    void numColumns() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new NumColumns(Integer.parseInt(""));
        });
    }
}