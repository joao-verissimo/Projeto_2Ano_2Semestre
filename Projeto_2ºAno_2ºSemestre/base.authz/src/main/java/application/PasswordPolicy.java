package application;

@FunctionalInterface
public interface PasswordPolicy {
    boolean isSatisfiedBy(String rawPassword);
}
