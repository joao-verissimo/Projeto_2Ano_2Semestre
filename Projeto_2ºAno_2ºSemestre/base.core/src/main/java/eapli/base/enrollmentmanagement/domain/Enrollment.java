package eapli.base.enrollmentmanagement.domain;


import eapli.base.coursemanagement.domain.Course;
import eapli.base.studentmanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

/**
 * The type Enrollment.
 *
 * @author joaomorais
 */
@Entity
@Table(name = "ENROLLMENTS")
public class Enrollment implements AggregateRoot<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENROLLMENT")
    private long id;


    @OneToOne
    private Student student;

    @OneToOne
    private Course course;

    private State state;


    /**
     * Instantiates a new Enrollment.
     *
     * @param student the student
     * @param course  the course
     */
    public Enrollment( Student student, Course course) {
        this.student = student;
        this.course = course;
        this.state = State.WAITING;
    }

    /**
     * Instantiates a new Enrollment.
     */
    public Enrollment(){

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets course.
     *
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public State getState() {
        return state;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", state=" + state +
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
