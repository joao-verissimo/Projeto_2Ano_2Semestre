package application;

import application.AuthenticationService;
import application.PasswordPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import application.*;

import domain.repositories.UserRepository;
import eapli.framework.util.Utility;
import eapli.framework.validations.Invariants;

/**
 * Registry of all authz service objects. Helper class for scenarios without
 * spring Dependency Injection. In order to properly use the registry it is
 * necessary to call its
 * {@link application.AuthzRegistry#configure(domain.repositories.UserRepository,PasswordPolicy, org.springframework.security.crypto.password.PasswordEncoder)
 * configure} method in the start of the application to inject the proper
 * {@link «repositories.UserRepository
 * UserRepository} implementation.
 * <p>
 * For instance,
 *
 * <pre>
 * <code>
 *    public static void main(final String[] args) {
 *       AuthzRegistry.configure(PersistenceContext.repositories().users(),
 *               new CafeteriaPasswordPolicy(), new PlainTextEncoder());
 *
 *       new ECafeteriaBackoffice().run(args);
 *   }
 * </code>
 * </pre>
 *
 * Afterwards, in order to use these objects, you just need to grab the
 * singleton from the registry, e.g.
 *
 * <pre>
 * <code>
 * public class RegisterDishTypeController implements Controller {
 *
 *   private final AuthorizationService authz = AuthzRegistry.authorizationService();
 *   private final DishTypeRepository repository = PersistenceContext.repositories().dishTypes();
 *
 *   public DishType registerDishType(final String acronym, final String description) {
 *       authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
 *               CafeteriaRoles.MENU_MANAGER);
 *
 *       final DishType newDishType = new DishType(acronym, description);
 *       return this.repository.save(newDishType);
 *   }
 * }
 *
 * </code>
 * </pre>
 *
 * @author Paulo Gandra de Sousa
 */
@Utility
public final class AuthzRegistry {

    private static application.AuthorizationService authorizationSvc;
    private static application.AuthenticationService authenticationService;
    private static application.UserManagementService userService;

    private AuthzRegistry() {
        // ensure utility
    }

    /**
     * Helper method to initialize the registry in case you are not using Spring Dependency
     * Injection. This method should be called <strong>only once</strong> on application
     * startup.
     *
     * @param userRepo
     * @param policy
     * @param encoder
     */
    public static void configure(final UserRepository userRepo, final PasswordPolicy policy,
                                 final PasswordEncoder encoder) {
        authorizationSvc = new application.AuthorizationService();
        authenticationService = new AuthenticationService(userRepo, authorizationSvc, policy, encoder);
        userService = new application.UserManagementService(userRepo, policy, encoder);
    }

    /**
     * @return the {@link UserManagementService}
     */
    public static UserManagementService userService() {
        Invariants.nonNull(userService);
        return userService;
    }

    /**
     * @return the {@link AuthenticationService}
     */
    public static AuthenticationService authenticationService() {
        Invariants.nonNull(authenticationService);
        return authenticationService;
    }

    /**
     * @return the {@link AuthorizationService}
     */
    public static AuthorizationService authorizationService() {
        Invariants.nonNull(authorizationSvc);
        return authorizationSvc;
    }
}
