package am.friendsWebGroup.kidoskindergarten.dto.babysitterDto;

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
public class BabySitterUserResponseDto {

    private int id;

}
