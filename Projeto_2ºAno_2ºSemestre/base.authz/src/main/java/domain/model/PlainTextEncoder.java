package domain.model;

import org.springframework.security.crypto.password.PasswordEncoder;

public final class PlainTextEncoder implements PasswordEncoder {
    public PlainTextEncoder() {
    }

    public String encode(final CharSequence rawPassword) {
        return rawPassword.toString();
    }

    public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
