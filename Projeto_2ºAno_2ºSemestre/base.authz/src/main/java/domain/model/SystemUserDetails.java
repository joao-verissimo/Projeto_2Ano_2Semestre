package domain.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SystemUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private final String email;
    private final String password;
    private final boolean isActive;
    private final List<GrantedAuthority> authorities;

    public SystemUserDetails(final SystemUserAuth user) {
        this.password = user.encodedPassword();
        this.email = user.email().toString();
        this.isActive = user.isActive();
        this.authorities = (List)user.roleTypes().stream().map((role) -> {
            return new SimpleGrantedAuthority(role.toString());
        }).collect(Collectors.toList());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.email;
    }

    public boolean isAccountNonExpired() {
        return this.isEnabled();
    }

    public boolean isAccountNonLocked() {
        return this.isEnabled();
    }

    public boolean isCredentialsNonExpired() {
        return this.isEnabled();
    }

    public boolean isEnabled() {
        return this.isActive;
    }
}
