package eapli.base.coursemanagement.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable

public class Code implements ValueObject, Comparable<Code> {

    private String valuecode;

    public Code(String valuecode) {
        this.valuecode = valuecode;
    }

    protected Code() {
    }

    public String getValue() {
        return valuecode;
    }

    public void setValueCode(String valuecode){
        this.valuecode = valuecode;
    }

    @Override
    public int compareTo(Code o) {
        return 0;
    }

    @Override
    public String toString() {
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
