package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class SequenceofSections implements ValueObject {
    private final String sequenceOfSections;

    public SequenceofSections(String value) {
        this.sequenceOfSections = value;
    }

    public SequenceofSections() {
        this.sequenceOfSections = null;
    }

    public String getValue() {
        return sequenceOfSections;
    }
}
