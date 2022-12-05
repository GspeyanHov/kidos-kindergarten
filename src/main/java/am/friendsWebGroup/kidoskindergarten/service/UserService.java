package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.entity.User;

public interface UserService {

    User saveUser(CreateUserDto dto);

    AuthResponseDto login(AuthRequestDto authRequestDto);
}
