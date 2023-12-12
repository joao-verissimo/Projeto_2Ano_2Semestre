package eapli.base.managermanagement.builder;

import application.AuthzRegistry;
import application.UserManagementService;
import domain.model.Role;
import domain.model.SystemUserAuth;
import eapli.base.managermanagement.domain.Manager;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Manager builder.
 */
public class ManagerBuilder implements DomainFactory<Manager> {

    private final UserManagementService userSvc = AuthzRegistry.userService();
    private SystemUserAuth user;


    /**
     * With manager builder.
     *
     * @param email     the email
     * @param password  the password
     * @param fullName  the full name
     * @param shortName the short name
     * @return the manager builder
     */
    public ManagerBuilder with(final String email, final String password, final String fullName, final String shortName) {
        withSystemUser(email,password,fullName,shortName);
        return this;
    }

    /**
     * With system user manager builder.
     *
     * @param email     the email
     * @param password  the password
     * @param fullName  the full name
     * @param shortName the short name
     * @return the manager builder
     */
    public ManagerBuilder withSystemUser(final String email, final String password, String fullName, String shortName) {
        Role[] roleTypes = BaseRoles.admin();
        Set<Role> role = new HashSet<>(Arrays.asList(roleTypes));
        this.user = userSvc.registerNewUser(email, password, fullName, shortName, role, CurrentTimeCalendars.now());
        return this;
    }

    @Override
    public Manager build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        Manager manager;

        manager = new Manager(user);

        return manager;
    }
}

