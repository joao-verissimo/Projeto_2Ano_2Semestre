package application;

import domain.model.Role;
import java.util.Optional;

@FunctionalInterface
public interface Authenticator {
    Optional<UserSession> authenticate(String username, String rawPassword, Role... requiredRoles);
}
