package am.friendsWebGroup.kidoskindergarten.api;

import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.authDto.AuthResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.CreateEventRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.EventResponseDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.CreateUserDto;
import am.friendsWebGroup.kidoskindergarten.dto.userDto.ResponseUserDto;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public interface EventApi {

    ResponseEntity<EventResponseDto> createEvent(CreateEventRequestDto createEventRequestDto);

}
