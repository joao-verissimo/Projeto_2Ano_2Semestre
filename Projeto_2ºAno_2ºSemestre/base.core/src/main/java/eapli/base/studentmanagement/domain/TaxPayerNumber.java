package eapli.base.studentmanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

/**
 * The type Tax payer number.
 */
@Embeddable
public class TaxPayerNumber {

    private static final Pattern VALID_TAX_PAYER_REGEX = Pattern.compile("^[0-9]{9}$");
    private String taxPayerNumber;

    /**
     * Instantiates a new Tax payer number.
     *
     * @param taxPayerNumber the tax payer number
     */
    public TaxPayerNumber(String taxPayerNumber) {
        Preconditions.nonEmpty(taxPayerNumber,"Tax Payer Number can't be empty or null");
        Preconditions.matches(VALID_TAX_PAYER_REGEX, taxPayerNumber, "Invalid Tax Payer (must have 9 digits): " +taxPayerNumber);;
        this.taxPayerNumber = taxPayerNumber;
    }

    /**
     * Instantiates a new Tax payer number.
     */
    protected TaxPayerNumber(){

    }

    /**
     * Gets tax payer number.
     *
     * @return the tax payer number
     */
    public String getTaxPayerNumber() {
        return taxPayerNumber;
    }

    /**
     * Value of tax payer number.
     *
     * @param taxPayerNumber the tax payer number
     * @return the tax payer number
     */
    public static TaxPayerNumber valueOf(final String taxPayerNumber) {
        return new TaxPayerNumber(taxPayerNumber);
    }
}
