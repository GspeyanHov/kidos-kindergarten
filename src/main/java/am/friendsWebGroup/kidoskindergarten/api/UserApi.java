package am.friendsWebGroup.kidoskindergarten.api;

import am.friendsWebGroup.kidoskindergarten.dto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.CreateUserDto;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    ResponseEntity<?> registerUser(CreateUserDto createUserDto);

    ResponseEntity<AuthResponseDto> login(AuthRequestDto authRequestDto);
}
