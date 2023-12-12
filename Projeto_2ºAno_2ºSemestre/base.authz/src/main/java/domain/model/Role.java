package domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Role implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    private String roleName;

    private Role(final String role) {
        Preconditions.nonEmpty(role);
        this.roleName = role;
    }

    protected Role() {
    }

    public String toString() {
        return this.roleName;
    }

    public static Role valueOf(final String role) {
        return new Role(role);
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Role)) {
            return false;
        } else {
            Role other = (Role)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$roleName = this.roleName;
                Object other$roleName = other.roleName;
                if (this$roleName == null) {
                    if (other$roleName != null) {
                        return false;
                    }
                } else if (!this$roleName.equals(other$roleName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $roleName = this.roleName;
        result = result * 59 + ($roleName == null ? 43 : $roleName.hashCode());
        return result;
    }
}

