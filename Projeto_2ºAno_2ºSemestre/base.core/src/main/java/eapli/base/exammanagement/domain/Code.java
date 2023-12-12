package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Code implements ValueObject, Comparable<Code> {


    private final String valuecode;

    public Code(String value) {
        this.valuecode = value;
    }

    public Code() {
        this.valuecode = null;
    }

    @Override
    public int compareTo(eapli.base.exammanagement.domain.Code o) {
        return 0;
    }

    @Override
    public String toString() {
        return valuecode;
    }
    public String getValue() {
        return valuecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;
        Code code = (Code) o;
        return valuecode.equals(code.valuecode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valuecode);
    }
}

