package eapli.base.studentmanagement.domain;

import eapli.base.coursemanagement.domain.Course;
import eapli.framework.domain.model.AggregateRoot;
import domain.model.SystemUserAuth;


import javax.persistence.*;
import java.util.List;

/**
 * The type Student.
 */
@Entity
public class Student implements AggregateRoot<Long>{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long mecanographicNumber;
    private BirthDate birthdate;

    private TaxPayerNumber taxPayerNumber;

    @OneToOne
    private SystemUserAuth user;
    /**
     * The Course.
     */
    @OneToMany
    List<Course> Course;

    /**
     * Instantiates a new Student.
     */
    protected Student() {
        // for ORM only
    }

    /**
     * Instantiates a new Student.
     *
     * @param user           the user
     * @param birthdate      the birthdate
     * @param taxPayerNumber the tax payer number
     */
    public Student(SystemUserAuth user, BirthDate birthdate, TaxPayerNumber taxPayerNumber) {
        this.user = user;
        this.birthdate = birthdate;
        this.taxPayerNumber = taxPayerNumber;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    /**
     * Sets mecanographic number.
     *
     * @param mecanographicNumber the mecanographic number
     */
    public void setMecanographicNumber(Long mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
    }

    /**
     * Gets mecanographic number.
     *
     * @return the mecanographic number
     */
    public Long getMecanographicNumber() {
        return mecanographicNumber;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public SystemUserAuth getUser() {
        return user;
    }

    /**
     * Append course.
     *
     * @param course the course
     */
    public void appendCourse(List<Course> course) {this.Course.addAll(course);}

    @Override
    public String toString() {
        return "Student{" +
                "mecanographicNumber=" + mecanographicNumber +
                ", birthdate=" + birthdate +
                ", taxPayerNumber=" + taxPayerNumber +
                ", user=" + user +
                '}';
    }

    @Override
    public Long identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
