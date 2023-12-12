package application.exceptions;

public class UnauthenticatedException extends RuntimeException {
    private static final long serialVersionUID = 1740612291648275001L;

    public UnauthenticatedException() {
    }

    public UnauthenticatedException(final String message) {
        super(message);
    }
}
