package eapli.base.studentmanagement.domain;

import eapli.base.teachermanagement.domain.TaxPayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxPayerNumberTest {
    @Test
    public void ensureTaxPayerCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayerNumber(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayerNumber("1234567891");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayerNumber("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayerNumber("12345678");
        });
    }

    @Test
    void getTaxPayer() {
        TaxPayerNumber actual = new TaxPayerNumber("123456789");
        TaxPayerNumber expected = new TaxPayerNumber("123456789");
        assertEquals(actual.getTaxPayerNumber(),expected.getTaxPayerNumber());
    }

    @Test
    void valueOf() {
        String tax = "123456789";
        TaxPayerNumber actual = new TaxPayerNumber("123456789");
        assertEquals(actual.getTaxPayerNumber(),TaxPayerNumber.valueOf(tax).getTaxPayerNumber());
    }

}