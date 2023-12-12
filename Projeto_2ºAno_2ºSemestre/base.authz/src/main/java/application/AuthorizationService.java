package application;

import application.exceptions.UnauthenticatedException;
import application.exceptions.UnauthorizedException;
import domain.model.Role;
import domain.model.SystemUserAuth;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationService {
    private static final Logger LOGGER = LogManager.getLogger(AuthorizationService.class);
    private UserSession theSession = null;

    protected AuthorizationService() {
    }

    Optional<UserSession> createSessionForUser(final SystemUserAuth user) {
        if (user != null) {
            this.theSession = new UserSession(user);
        } else {
            this.clearSession();
        }

        return this.session();
    }

    public Optional<UserSession> clearSession() {
        this.theSession = null;
        return this.session();
    }

    public boolean hasSession() {
        return this.theSession != null;
    }

    public Optional<UserSession> session() {
        return Optional.ofNullable(this.theSession);
    }

    public boolean isAuthenticatedUserAuthorizedTo(final Role... actions) {
        return (Boolean)this.session().map((us) -> {
            return us.authenticatedUser().hasAny(actions);
        }).orElse(false);
    }

    public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        UserSession us = (UserSession)this.session().orElseThrow(() -> {
            LOGGER.info("Unauthenticated access attempt");
            return new UnauthenticatedException();
        });
        if (!us.authenticatedUser().hasAny(actions)) {
            LOGGER.info("Unauthorized access attempt by user {}", us.authenticatedUser().email());
            throw new UnauthorizedException(us.authenticatedUser(), actions);
        }
    }

    public Optional<SystemUserAuth> loggedinUserWithPermissions(final Role... actions) {
        return this.session().filter((us) -> {
            return us.authenticatedUser().hasAny(actions);
        }).map(UserSession::authenticatedUser);
    }
}
