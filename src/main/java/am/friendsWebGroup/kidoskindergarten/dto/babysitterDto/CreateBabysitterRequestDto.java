package am.friendsWebGroup.kidoskindergarten.dto.babysitterDto;

import am.friendsWebGroup.kidoskindergarten.entity.Experience;
import am.friendsWebGroup.kidoskindergarten.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBabysitterRequestDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private Experience experience;
    private String pic_url;
    private BabySitterUserResponseDto babySitterUserResponseDto;
}
