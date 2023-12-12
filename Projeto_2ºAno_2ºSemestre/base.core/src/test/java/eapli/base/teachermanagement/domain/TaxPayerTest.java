package eapli.base.teachermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxPayerTest {

    @Test
    public void ensureTaxPayerCantBeNullOrEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayer(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayer("1234567891");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayer("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new TaxPayer("12345678");
        });
    }

    @Test
    void getTaxPayer() {
        TaxPayer actual = new TaxPayer("123456789");
        TaxPayer expected = new TaxPayer("123456789");
        assertEquals(actual.getTaxPayer(),expected.getTaxPayer());
    }

    @Test
    void valueOf() {
        String tax = "123456789";
        TaxPayer actual = new TaxPayer("123456789");
        assertEquals(actual.getTaxPayer(),TaxPayer.valueOf(tax).getTaxPayer());
    }
}