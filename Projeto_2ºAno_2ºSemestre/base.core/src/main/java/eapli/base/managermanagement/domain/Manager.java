package eapli.base.managermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import domain.model.SystemUserAuth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The type Manager.
 */
@Entity
public class Manager implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private SystemUserAuth user;

    /**
     * Instantiates a new Manager.
     */
    protected Manager(){}

    /**
     * Instantiates a new Manager.
     *
     * @param user the user
     */
    public Manager(SystemUserAuth user){
        this.user = user;
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
}
