package eapli.base.teachermanagement.domain;

import domain.model.SystemUserAuth;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Teacher.
 */
@Entity (name = "Teacher")
public class Teacher  implements AggregateRoot<Acronym> {


    @EmbeddedId
    private Acronym acronym;

    private BirthDate birthDate;

    private TaxPayer taxPayer;
    @OneToOne
    private SystemUserAuth user;

    /**
     * Instantiates a new Teacher.
     */
    protected Teacher(){}

    /**
     * Sets acronym.
     *
     * @param acronym the acronym
     */
    public void setAcronym(Acronym acronym) {
        this.acronym = acronym;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets tax payer.
     *
     * @param taxPayer the tax payer
     */
    public void setTaxPayer(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(SystemUserAuth user) {
        this.user = user;
    }

    /**
     * Instantiates a new Teacher.
     *
     * @param user      the user
     * @param acronym   the acronym
     * @param birthDate the birth date
     * @param taxPayer  the tax payer
     */
    public Teacher(SystemUserAuth user, Acronym acronym, BirthDate birthDate, TaxPayer taxPayer) {
        this.user = user;
        this.acronym = acronym;
        this.birthDate = birthDate;
        this.taxPayer = taxPayer;

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
     * Gets acronym.
     *
     * @return the acronym
     */
    public Acronym getAcronym() {
        return acronym;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public BirthDate getBirthDate() {
        return birthDate;
    }

    /**
     * Gets tax payer.
     *
     * @return the tax payer
     */
    public TaxPayer getTaxPayer() {
        return taxPayer;
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Acronym other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(acronym, teacher.acronym) && Objects.equals(birthDate, teacher.birthDate) && Objects.equals(taxPayer, teacher.taxPayer) && Objects.equals(user, teacher.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronym, birthDate, taxPayer, user);
    }

    @Override
    public Acronym identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(Acronym id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "acronym=" + acronym +
                ", birthDate=" + birthDate +
                ", taxPayer=" + taxPayer +
                ", user=" + user +
                '}';
    }
}
