package am.friendsWebGroup.kidoskindergarten.validation.constraint;

import am.friendsWebGroup.kidoskindergarten.validation.validator.UserPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserPasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

  String message() default
          """
           Invalid password! The password should have 8 up to 32 characters at least one
           uppercase character, one lowercase character, one digit,
           one special symbol and no whitespaces!""";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
