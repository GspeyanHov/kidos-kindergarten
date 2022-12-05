package am.friendsWebGroup.kidoskindergarten.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "event")

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;
    private Date duration;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private EventType eventType;
    private String place;
    @ManyToMany
    private List<Kid> kid;

}
