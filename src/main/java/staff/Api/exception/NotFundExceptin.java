package staff.Api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFundExceptin extends RuntimeException {
    public NotFundExceptin(String message){super(message);}
}
