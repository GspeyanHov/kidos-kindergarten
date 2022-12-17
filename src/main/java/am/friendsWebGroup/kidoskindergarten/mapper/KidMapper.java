package am.friendsWebGroup.kidoskindergarten.mapper;

import am.friendsWebGroup.kidoskindergarten.dto.kidDto.CreateKidRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidParentResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.kidDto.KidResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.Kid;
import am.friendsWebGroup.kidoskindergarten.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KidMapper {

    Kid mapToEntity(CreateKidRequestDto createKidRequestDto);

    KidResponseDto mapToDto(Kid kid);
}
