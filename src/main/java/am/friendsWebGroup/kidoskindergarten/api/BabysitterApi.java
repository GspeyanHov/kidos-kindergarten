package am.friendsWebGroup.kidoskindergarten.api;

import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabysitterResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.CreateBabysitterRequestDto;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public interface BabysitterApi {

    ResponseEntity<BabysitterResponseDto> registerBabysitter(CreateBabysitterRequestDto createBabysitterRequestDto);
}
