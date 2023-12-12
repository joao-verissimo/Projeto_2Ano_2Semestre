package application.exceptions;

import domain.model.Role;
import domain.model.SystemUserAuth;

/**
 * @author Paulo Gandra Sousa
 *
 */
public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = -5601684795034834561L;

    private final SystemUserAuth user;
    private final Role[] roles;

    /**
     * @param message
     * @param user
     * @param roles
     */
    public UnauthorizedException(final String message, final SystemUserAuth user, final Role... roles) {
        super(buildMessage(message, user, roles));
        this.roles = roles;
        this.user = user;
    }

    /**
     * @param user
     * @param roles
     */
    public UnauthorizedException(final SystemUserAuth user, final Role... roles) {
        super(buildMessage("", user, roles));
        this.roles = roles;
        this.user = user;
    }

    private static String buildMessage(final String original, final SystemUserAuth user, final Role... roles) {
        return "User " + user.email() + " is not authorized to perform one of these actions: " + roles + "\n"
                + original;
    }

    /**
     *
     * @return the user trying to access the resource
     */
    public SystemUserAuth user() {
        return user;
    }

    /**
     *
     * @return the roles that are needed to perform the action
     */
    public Role[] intendedRoles() {
        return roles;
    }
}

