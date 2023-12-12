package eapli.base.teachermanagement.domain;

import eapli.base.studentmanagement.domain.TaxPayerNumber;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

/**
 * The type Tax payer.
 */
@Embeddable
public class TaxPayer {

    private static final Pattern VALID_TAX_PAYER_REGEX = Pattern.compile("^[0-9]{9}$");
    private String taxPayer;

    /**
     * Instantiates a new Tax payer.
     *
     * @param taxPayer the tax payer
     */
    public TaxPayer(String taxPayer) {
        Preconditions.nonEmpty(taxPayer,"Tax Payer Number can't be empty or null");
        Preconditions.matches(VALID_TAX_PAYER_REGEX, taxPayer, "Invalid Tax Payer (must have 9 digits): " +taxPayer);;
        this.taxPayer = taxPayer;
    }

    /**
     * Instantiates a new Tax payer.
     */
    protected TaxPayer(){

    }

    /**
     * Gets tax payer.
     *
     * @return the tax payer
     */
    public String getTaxPayer() {
        return taxPayer;
    }

    /**
     * Value of tax payer.
     *
     * @param taxPayerNumber the tax payer number
     * @return the tax payer
     */
    public static TaxPayer valueOf(final String taxPayerNumber) {
        return new TaxPayer(taxPayerNumber);
    }

    @Override
    public String toString() {
        return taxPayer;
    }
}
