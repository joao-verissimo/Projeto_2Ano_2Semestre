package domain.model;

import application.PasswordPolicy;

public final class NilPasswordPolicy implements PasswordPolicy {
    public NilPasswordPolicy() {
    }

    public boolean isSatisfiedBy(final String rawPassword) {
        return true;
    }
}
