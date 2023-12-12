package application;

import domain.model.SystemUserAuth;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;
import java.util.Calendar;
import java.util.UUID;

public final class UserSession implements ValueObject {
    private static final long serialVersionUID = 1L;
    private final SystemUserAuth authenticatedUser;
    private final UUID token;
    private final Calendar startedOn;

    public UserSession(final SystemUserAuth user) {
        Preconditions.nonNull(user, "user must not be null");
        this.authenticatedUser = user;
        this.token = UUID.randomUUID();
        this.startedOn = CurrentTimeCalendars.now();
    }

    public String toString() {
        EmailAddress var10000 = this.authenticatedUser.identity();
        return "" + var10000 + "@" + this.token;
    }

    public SystemUserAuth authenticatedUser() {
        return this.authenticatedUser;
    }

    public UUID token() {
        return this.token;
    }

    public Calendar startedOn() {
        return this.startedOn;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserSession)) {
            return false;
        } else {
            UserSession other;
            label44: {
                other = (UserSession)o;
                Object this$authenticatedUser = this.authenticatedUser();
                Object other$authenticatedUser = other.authenticatedUser();
                if (this$authenticatedUser == null) {
                    if (other$authenticatedUser == null) {
                        break label44;
                    }
                } else if (this$authenticatedUser.equals(other$authenticatedUser)) {
                    break label44;
                }

                return false;
            }

            Object this$token = this.token();
            Object other$token = other.token();
            if (this$token == null) {
                if (other$token != null) {
                    return false;
                }
            } else if (!this$token.equals(other$token)) {
                return false;
            }

            Object this$startedOn = this.startedOn();
            Object other$startedOn = other.startedOn();
            if (this$startedOn == null) {
                if (other$startedOn != null) {
                    return false;
                }
            } else if (!this$startedOn.equals(other$startedOn)) {
                return false;
            }

            return true;
        }
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $authenticatedUser = this.authenticatedUser();
        result = result * 59 + ($authenticatedUser == null ? 43 : $authenticatedUser.hashCode());
        Object $token = this.token();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        Object $startedOn = this.startedOn();
        result = result * 59 + ($startedOn == null ? 43 : $startedOn.hashCode());
        return result;
    }
}

