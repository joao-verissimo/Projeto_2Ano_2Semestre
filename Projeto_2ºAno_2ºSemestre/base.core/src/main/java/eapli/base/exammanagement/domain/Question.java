package eapli.base.exammanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Question implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String question;

    private String correctAnswer;

    private String answergiven;

    @Enumerated(EnumType.STRING)
    private TypeofQuestion type;

    public Question(String value, String correctAnswer, TypeofQuestion type) {
        this.question = value.substring(0, Math.min(value.length(), 255));
        this.correctAnswer = correctAnswer;
        this.type = type;
        this.answergiven=null;
    }

    public void setAnswergiven(String answergiven) {
        this.answergiven = answergiven;
    }

    public Question() {
    }


    public String getValue() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id.toString() +
                ", question='" + question+ '\'' +
                ", correctAnswer='" + correctAnswer+ '\'' +
                ", type=" + type.toString() +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
