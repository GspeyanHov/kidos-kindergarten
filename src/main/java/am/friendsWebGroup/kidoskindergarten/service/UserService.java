package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;

public interface UserService {

    ResponseUserDto saveUser(CreateUserDto dto);

    AuthResponseDto login(AuthRequestDto authRequestDto);

    ResponseUserDto findUserById(int id);

}
