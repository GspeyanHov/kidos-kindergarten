package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.eventDto.CreateEventRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.EventResponseDto;

public interface EventService {

    EventResponseDto createEvent(CreateEventRequestDto createEventRequestDto);
}
