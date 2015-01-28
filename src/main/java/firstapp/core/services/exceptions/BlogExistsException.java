package firstapp.core.services.exceptions;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogExistsException extends RuntimeException {
    public BlogExistsException() {
    }

    public BlogExistsException(String message) {
        super(message);
    }

    public BlogExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogExistsException(Throwable cause) {
        super(cause);
    }
}
