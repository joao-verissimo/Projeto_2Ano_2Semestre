package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class Title implements ValueObject {

    private final String valuetitle;

    public Title(String value) {
        this.valuetitle = value;
    }

    public Title() {
        this.valuetitle = null;
    }

    public String getValue() {
        return valuetitle;
    }

    @Override
    public String toString() {
        return  valuetitle;
    }
}
