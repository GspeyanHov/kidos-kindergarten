package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.dto.eventDto.CreateEventRequestDto;
import am.friendsWebGroup.kidoskindergarten.dto.eventDto.EventResponseDto;
import am.friendsWebGroup.kidoskindergarten.entity.Event;
import am.friendsWebGroup.kidoskindergarten.exception.EventCreationFailureException;
import am.friendsWebGroup.kidoskindergarten.mapper.EventMapper;
import am.friendsWebGroup.kidoskindergarten.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static am.friendsWebGroup.kidoskindergarten.exception.Error.EVENT_NOT_SAVED;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventResponseDto createEvent(CreateEventRequestDto createEventRequestDto) {
        if(createEventRequestDto == null){
            throw new EventCreationFailureException(EVENT_NOT_SAVED);
        }
        Event event = eventMapper.mapToEntity(createEventRequestDto);
         eventRepository.save(event);
         return eventMapper.mapToDto(event);
    }
}
