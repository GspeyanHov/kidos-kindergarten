package am.friendsWebGroup.kidoskindergarten.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.time.LocalDateTime.now;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ApiError> handleExceptions(BaseException ex) {
        Error error = ex.getError();

        ApiError apiError = ApiError.builder()
                .status(error.getHttpStatus())
                .timestamp(now())
                .message(error.getMessage())
                .errorCode(error.getCode())
                .build();

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
