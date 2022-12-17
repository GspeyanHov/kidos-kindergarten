package am.friendsWebGroup.kidoskindergarten.dto.eventDto;

import am.friendsWebGroup.kidoskindergarten.entity.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponseDto {

    private int id;
    private String title;
    private double price;
    private long duration;
    private String description;
    private EventType eventType;

}
