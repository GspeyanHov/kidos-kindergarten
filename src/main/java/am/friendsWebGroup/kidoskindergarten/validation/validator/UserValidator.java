package am.friendsWebGroup.kidoskindergarten.validation.validator;

import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.exception.UserAlreadyExistException;
import am.friendsWebGroup.kidoskindergarten.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import static am.friendsWebGroup.kidoskindergarten.exception.Error.DUPLICATE_EMAIL;

@Slf4j
@Component
@AllArgsConstructor
@Setter
public class UserValidator {

    private UserRepository userRepository;

    public void validateUserRegistration(User user) {
        validateEmail(user.getEmail());

    }

    private void validateEmail(String email) {
        if (userRepository.existsByEmailIgnoreCase(email)) {
            log.warn("Invalid email! There is an user in database with such email.");

            throw new UserAlreadyExistException(DUPLICATE_EMAIL);
        }
    }
}
