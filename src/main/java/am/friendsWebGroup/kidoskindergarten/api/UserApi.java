package am.friendsWebGroup.kidoskindergarten.api;

import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;
import org.springframework.http.ResponseEntity;
@SuppressWarnings("unused")
public interface UserApi {

    ResponseEntity<ResponseUserDto> registerUser(CreateUserDto createUserDto);

    ResponseEntity<AuthResponseDto> login(AuthRequestDto authRequestDto);

    ResponseEntity<ResponseUserDto> findUserById(int id);
}
