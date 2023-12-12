package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class Description implements ValueObject {
    private final String valuedescription;

    public Description(String value) {
        this.valuedescription = value;
    }

    public Description() {
        this.valuedescription = null;
    }

    public String getValue() {
        return valuedescription;
    }
}
