package am.friendsWebGroup.kidoskindergarten.mapper;

import am.friendsWebGroup.kidoskindergarten.dto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToEntity(CreateUserDto createUserDto);
}
