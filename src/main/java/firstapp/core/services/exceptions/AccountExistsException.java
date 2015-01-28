package firstapp.core.services.exceptions;

/**
 * Created by Rhea on 1/24/15.
 */
public class AccountExistsException extends RuntimeException{
    public AccountExistsException() {
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
