package firstapp.core.services.exceptions;

/**
 * Created by Rhea on 1/24/15.
 */
public class AccountDoesNotExistException  extends RuntimeException{
    public AccountDoesNotExistException() {
    }

    public AccountDoesNotExistException(String message) {
        super(message);
    }

    public AccountDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
