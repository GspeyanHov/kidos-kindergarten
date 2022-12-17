package am.friendsWebGroup.kidoskindergarten.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static am.friendsWebGroup.kidoskindergarten.exception.Error.CONSTRAINT_VIOLATION;
import static java.time.LocalDateTime.now;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {
        Error error = CONSTRAINT_VIOLATION;
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("errorCode", error.getCode());
        body.put("timestamp", Instant.now());
        body.put("status", error.getHttpStatus());
        body.put("message", error.getMessage());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        body.put("errors", errors);

        return ResponseEntity.badRequest().body(body);
    }

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
