package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Name implements ValueObject {
    private final String valueName;

    public Name(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Name value can only contain letters.");
        }
        this.valueName = value;
    }

    public Name() {
        this.valueName = null;
    }

    public String getValue() {
        return valueName;
    }

    private boolean isValid(String value) {
        return value != null && value.matches("[a-zA-Z\\s]+");
    }

    @Override
    public String toString() {
        return  valueName;
    }
}


