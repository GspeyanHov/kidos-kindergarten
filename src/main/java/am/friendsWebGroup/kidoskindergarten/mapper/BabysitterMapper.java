package am.friendsWebGroup.kidoskindergarten.mapper;

import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.BabysitterResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.babysitterDto.CreateBabysitterRequestDto;
import am.friendsWebGroup.kidoskindergarten.entity.Babysitter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BabysitterMapper {

    Babysitter mapToEntity(CreateBabysitterRequestDto createBabysitterRequestDto);

    BabysitterResponseDto mapToDto(Babysitter babysitter);
}
