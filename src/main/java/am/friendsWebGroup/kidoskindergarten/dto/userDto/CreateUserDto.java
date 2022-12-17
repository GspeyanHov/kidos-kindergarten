package am.friendsWebGroup.kidoskindergarten.dto.userDto;

import am.friendsWebGroup.kidoskindergarten.validation.constraint.Name;
import am.friendsWebGroup.kidoskindergarten.validation.constraint.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    @Name
    private String name;
    @Name
    private String surname;
    @Email
    private String email;
    @Password
    private String password;

}
