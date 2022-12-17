package am.friendsWebGroup.kidoskindergarten.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum Error {

    //400
    DUPLICATE_EMAIL(BAD_REQUEST, 4001, "This email already in use"),
    CONSTRAINT_VIOLATION(BAD_REQUEST, 4002, "There Is An Invalid Value In User Input"),

    KID_NOT_SAVED(BAD_REQUEST,4003 ,"User couldn't save kid successfully"),

    EVENT_NOT_SAVED(BAD_REQUEST,4004 ,"User couldn't save event successfully"),

    BABYSITTER_NOT_SAVED(BAD_REQUEST,4005 ,"babysitter didn't save successfully"),

    //401
    BAD_CREDENTIALS(UNAUTHORIZED, 4011, "User provided wrong credentials"),
    NOT_ACTIVE_ACCOUNT(UNAUTHORIZED, 4012, "User email is not confirmed"),

    //404
    NO_SUCH_USER(NOT_FOUND,4041 ,"User does not exist "),

    //403
    PERMISSION_DENIED(FORBIDDEN,4031 ,"You don't have such permission for that request");




    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

}
