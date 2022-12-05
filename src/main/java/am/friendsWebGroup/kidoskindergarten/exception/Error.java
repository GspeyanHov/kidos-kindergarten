package am.friendsWebGroup.kidoskindergarten.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Error {

    //400
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST,4001, "This email already in use"),


    //401
    BAD_CREDENTIALS(HttpStatus.UNAUTHORIZED,4011 ,"User provided wrong credentials"),
    NOT_ACTIVE_ACCOUNT(HttpStatus.UNAUTHORIZED, 4012, "User email is not confirmed");

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;
}
