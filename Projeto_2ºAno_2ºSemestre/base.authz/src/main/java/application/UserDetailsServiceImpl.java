package application;

import domain.repositories.UserRepository;
import java.util.Optional;

import domain.model.SystemUserAuth;
import domain.model.SystemUserDetails;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger LOGGER = LogManager.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;
    private final AuthorizationService authz;

    @Autowired
    public UserDetailsServiceImpl(final UserRepository userRepository, final AuthorizationService authz) {
        this.userRepository = userRepository;
        this.authz = authz;
    }

    @Transactional(
            readOnly = true
    )
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        LOGGER.debug("Loading User By Username: {}", username);
        Optional<SystemUserAuth> user = this.userRepository.ofIdentity(EmailAddress.valueOf(username));
        this.authz.createSessionForUser((SystemUserAuth)user.orElse(null));
        return (UserDetails)user.map(SystemUserDetails::new).orElseThrow(() -> {
            return new UsernameNotFoundException(username);
        });
    }
}

