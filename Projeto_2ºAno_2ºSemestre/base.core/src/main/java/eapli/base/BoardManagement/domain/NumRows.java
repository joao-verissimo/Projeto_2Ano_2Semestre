package eapli.base.BoardManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class NumRows implements ValueObject {

    private int numRows;

    private static final Pattern VALID_NUM_ROW_REGEX = Pattern.compile("^[1-9]\\d*$\n");

    public NumRows(int numRows) {
        this.numRows = numRows;
        Preconditions.nonNull(numRows,"Num row can't be null");
        //Preconditions.matches(VALID_NUM_ROW_REGEX, String.valueOf(numRows), "Invalid num row (must be positive): " +numRows);;
    }

    public NumRows() {
        //for orm only
    }

    public int numRows() {
        return numRows;
    }
}