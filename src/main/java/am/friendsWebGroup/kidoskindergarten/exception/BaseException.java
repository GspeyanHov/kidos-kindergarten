package am.friendsWebGroup.kidoskindergarten.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private final Error error;

    public BaseException(Error error) {
        this.error = error;
    }
}
