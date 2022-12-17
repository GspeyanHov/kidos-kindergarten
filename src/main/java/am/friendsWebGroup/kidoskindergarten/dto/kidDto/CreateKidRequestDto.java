package am.friendsWebGroup.kidoskindergarten.dto.kidDto;

import am.friendsWebGroup.kidoskindergarten.entity.Gender;
import am.friendsWebGroup.kidoskindergarten.entity.KidGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateKidRequestDto {

    private String name;
    private String surname;
    private KidGroup kidGroup;
    private Gender gender;
    private String pic_url;
    private KidParentResponseDto parent;
}
