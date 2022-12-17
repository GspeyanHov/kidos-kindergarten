package am.friendsWebGroup.kidoskindergarten.dto.userDto;

import am.friendsWebGroup.kidoskindergarten.entity.Kid;
import am.friendsWebGroup.kidoskindergarten.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUserDto {

    private String name;
    private String surname;
    private String email;
    private Role role;
    private Kid kid;

}
