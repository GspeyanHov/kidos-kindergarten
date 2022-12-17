package am.friendsWebGroup.kidoskindergarten.api;

import am.friendsWebGroup.kidoskindergarten.dto.kidDto.CreateKidRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidParentResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidResponseDto;
import am.friendsWebGroup.kidoskindergarten.security.CurrentUser;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public interface KidApi {

    ResponseEntity<KidResponseDto> registerKid(CreateKidRequestDto createKidDto);
}
