package firstapp.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Rhea on 1/24/15.
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{
    public ConflictException() {
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }
}
