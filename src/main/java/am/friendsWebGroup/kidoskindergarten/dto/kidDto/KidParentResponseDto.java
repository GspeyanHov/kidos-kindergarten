package am.friendsWebGroup.kidoskindergarten.dto.kidDto;

import am.friendsWebGroup.kidoskindergarten.entity.User;
import am.friendsWebGroup.kidoskindergarten.security.CurrentUser;
import am.friendsWebGroup.kidoskindergarten.validation.constraint.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KidParentResponseDto {

    @Name
    private String name;
    @Name
    private String surname;
    @Email
    private String email;

}
