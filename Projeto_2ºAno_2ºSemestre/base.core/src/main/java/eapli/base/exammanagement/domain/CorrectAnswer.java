package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.ValueObject;

public class CorrectAnswer implements ValueObject {

    private final String correctAnswer;

    public CorrectAnswer(String value) {
        this.correctAnswer = value;
    }

    public CorrectAnswer() {
        this.correctAnswer = null;
    }

    public String getValue() {
        return correctAnswer;
    }
}
