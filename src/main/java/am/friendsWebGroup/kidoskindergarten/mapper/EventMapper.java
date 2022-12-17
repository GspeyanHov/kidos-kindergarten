package am.friendsWebGroup.kidoskindergarten.mapper;

import am.friendsWebGroup.kidoskindergarten.dto.eventDto.CreateEventRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.EventResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event mapToEntity(CreateEventRequestDto createEventRequestDto);

    EventResponseDto mapToDto(Event event);
}
