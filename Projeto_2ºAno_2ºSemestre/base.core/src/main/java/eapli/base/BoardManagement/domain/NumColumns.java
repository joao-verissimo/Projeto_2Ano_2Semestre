package eapli.base.BoardManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class NumColumns implements ValueObject {

    private int numColumns;

    private static final Pattern VALID_NUM_COLUMN_REGEX = Pattern.compile("^[1-9]\\d*$\n");

    public NumColumns() {
        //for orm only
    }

    public NumColumns(int numColumns) {
        this.numColumns = numColumns;
        Preconditions.nonNull(numColumns,"Num column can't be null");
        //Preconditions.matches(VALID_NUM_COLUMN_REGEX, String.valueOf(numColumns), "Invalid num column (must be positive): " +numColumns);;
    }

    public int numColumns() {
        return numColumns;
    }
}