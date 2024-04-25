package staff.Api.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import staff.Api.response.BaseBodyResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {

    private ResponseEntity<BaseBodyResponse> buildErrorResponse(HttpStatus status, String mensagem){
        BaseBodyResponse response = BaseBodyResponse.builder()
                .httpStatus(status.toString())
                .message(mensagem)
                .build();
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<BaseBodyResponse> handleUnauthorizedException(UnauthorizedException ex) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Não autorizado");
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<BaseBodyResponse> handleForbiddenException(ForbiddenException ex) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, "Acesso proibido");
    }

    @ExceptionHandler({EntityNotFoundException.class, NotFundExceptin.class})
    public ResponseEntity<BaseBodyResponse> handleNotFoundException(Exception ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Recurso não encontrado");
    }


}
