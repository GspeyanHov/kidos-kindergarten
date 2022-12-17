package am.friendsWebGroup.kidoskindergarten.mapper;

import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidParentResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToEntity(CreateUserDto createUserDto);

    ResponseUserDto mapToDto(User user);
    KidParentResponseDto mapToParentDto(User user);

    User mapToParentEntity(KidParentResponseDto kidParentResponseDto);

}
