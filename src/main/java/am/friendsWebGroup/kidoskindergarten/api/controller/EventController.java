package am.friendsWebGroup.kidoskindergarten.api.controller;

import am.friendsWebGroup.kidoskindergarten.api.EventApi;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.CreateEventRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.EventResponseDto;
import am.friendsWebGroup.kidoskindergarten.service.EventServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/event")
public class EventController implements EventApi {

    private final EventServiceImpl eventService;

    @Override
    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody CreateEventRequestDto createEventRequestDto) {
        return ResponseEntity.status(CREATED).body(eventService.createEvent(createEventRequestDto));
    }
}
