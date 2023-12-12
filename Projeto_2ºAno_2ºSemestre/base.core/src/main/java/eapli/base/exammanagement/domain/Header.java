package eapli.base.exammanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Header {
    private  Feedback feedback;
    private Grade grade;
    private String globalSetting;
    private Description description;

    @Override
    public String toString() {
        return  "feedback=" + feedback +
                ", grade=" + grade +
                ", globalSetting='" + globalSetting + '\'' +
                ", description=" + description.getValue() +
                '}';
    }

    public Header() {

    }



    public enum Feedback {
        NONE,
        ON_SUBMISSION,
        AFTER_CLOSING
    }
    public enum Grade {
        NONE,
        ON_SUBMISSION,
        AFTER_CLOSING
    }

    public Header(Description description, Feedback feedback, Grade grade, String globalSetting) {
        this.description = description;
        this.feedback = feedback;
        this.grade = grade;
        this.globalSetting = globalSetting;
    }

}
