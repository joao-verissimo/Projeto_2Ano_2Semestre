package eapli.base.classmanagement.domain;

import eapli.base.teachermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

/**
 * The type Class.
 */
@Entity
@Table(name = "CLASS")
public class Class implements AggregateRoot<Long> {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Duration duration;

    @Embedded
    private DayOfTheWeek dayoftheweek;

    @ManyToOne
    private Teacher teacher;

    /**
     * Instantiates a new Class.
     *
     * @param title        the title
     * @param duration     the duration
     * @param dayoftheweek the dayoftheweek
     * @param teacher      the teacher
     */
    public Class(Title title, Duration duration, DayOfTheWeek dayoftheweek,Teacher teacher) {
        this.title = title;
        this.duration = duration;
        this.dayoftheweek = dayoftheweek;
        this.teacher = teacher;
    }

    /**
     * Instantiates a new Class.
     */
    protected Class(){

    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Gets dayoftheweek.
     *
     * @return the dayoftheweek
     */
    public DayOfTheWeek getDayoftheweek() {
        return dayoftheweek;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public Long identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public Title getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ID: ").append(id).append("\n");
        sb.append("Title: ").append(title.getTitle()).append("\n");
        sb.append("Start Time: ").append(duration.getInitialTime()).append("\n");
        sb.append("End Time: ").append(duration.getFinishTime()).append("\n");
        sb.append("Duration: ").append(duration.getDurationValue()).append("\n");
        sb.append("Day of the Week: ").append(dayoftheweek.getDayoftheweek()).append("\n");
        sb.append("Teacher: ").append(teacher != null ? teacher.getUser().name() : "N/A").append("\n");
        return sb.toString();
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Sets dayoftheweek.
     *
     * @param dayOfTheWeek the day of the week
     */
    public void setDayoftheweek(DayOfTheWeek dayOfTheWeek) {
        this.dayoftheweek = dayOfTheWeek;
    }
}
