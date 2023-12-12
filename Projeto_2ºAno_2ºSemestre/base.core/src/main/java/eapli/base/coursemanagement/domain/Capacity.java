package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable

public class Capacity implements ValueObject {
    private final int valuecapacity;

    public Capacity(int value) {
        this.valuecapacity = value;
    }

    public Capacity() {
        this.valuecapacity = 0;
    }

    public static Capacity of(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive value");
        }
        return new Capacity(value);
    }

    public int getValue() {
        return valuecapacity;
    }

    @Override
    public String toString() {
        return String.valueOf(valuecapacity);
    }
}
