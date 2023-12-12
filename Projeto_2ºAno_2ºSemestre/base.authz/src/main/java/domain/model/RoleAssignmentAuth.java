package domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "RoleAssignmentAuth")
@Table(
        name = "T_ROLEASSIGNMENT"
)
public class RoleAssignmentAuth implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long pk;
    private final Role type;
    @Temporal(TemporalType.DATE)
    private final Calendar assignedOn;
    @Temporal(TemporalType.DATE)
    private Calendar unassignedOn;
    private boolean expired;

    public RoleAssignmentAuth(final Role type) {
        this(type, CurrentTimeCalendars.now());
    }

    public RoleAssignmentAuth(final Role type, final Calendar assignedOn) {
        Preconditions.noneNull(new Object[]{type, assignedOn});
        this.type = type;
        this.assignedOn = assignedOn;
        this.expired = false;
    }

    protected RoleAssignmentAuth() {
        this.type = null;
        this.assignedOn = null;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof RoleAssignmentAuth)) {
            return false;
        } else {
            RoleAssignmentAuth other = (RoleAssignmentAuth)o;
            boolean b = this.type == other.type && this.assignedOn.equals(other.assignedOn) && this.expired == other.expired;
            if (!b) {
                return false;
            } else {
                return this.unassignedOn != null && this.unassignedOn.equals(other.unassignedOn) || this.unassignedOn == null && other.unassignedOn == null;
            }
        }
    }

    public int hashCode() {
        return (new HashCoder()).with(this.type).with(this.assignedOn).with(this.expired).with(this.unassignedOn).code();
    }

    public String toString() {
        return this.type + "@" + this.assignedOn;
    }

    public Role type() {
        return this.type;
    }

    public boolean isOf(final Role r) {
        return this.type.equals(r);
    }

    public boolean unassign() {
        if (this.expired) {
            return false;
        } else {
            this.expired = true;
            this.unassignedOn = CurrentTimeCalendars.now();
            return true;
        }
    }

    public Optional<Calendar> unassignedOn() {
        return Optional.ofNullable(this.unassignedOn);
    }
}

