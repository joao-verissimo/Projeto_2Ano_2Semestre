package eapli.base.MeetingManagement.domain;

import domain.model.SystemUserAuth;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
/**
 * @author Jorge Lima
 */
@Entity
public class MeetingAccessList implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccessList;

    @ManyToOne
    private SystemUserAuth user;

    private InviteState inviteState;

    @ManyToOne(cascade = CascadeType.ALL)
    private Meeting meeting;

    protected MeetingAccessList() {
        // for ORM only
    }

    public MeetingAccessList(SystemUserAuth user, InviteState inviteState, Meeting meeting) {
        this.user = user;
        this.inviteState = inviteState;
        this.meeting = meeting;
    }

    public void setInviteState(InviteState inviteState) {
        this.inviteState = inviteState;
    }

    public Long idAccessList() {
        return idAccessList;
    }

    public SystemUserAuth user() {
        return user;
    }

    public InviteState inviteState() {
        return inviteState;
    }

    public Meeting meeting() {
        return meeting;
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
