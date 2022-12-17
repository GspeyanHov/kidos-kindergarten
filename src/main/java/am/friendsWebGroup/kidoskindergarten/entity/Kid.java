package am.friendsWebGroup.kidoskindergarten.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kid")

public class Kid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)
    private KidGroup kidGroup;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String pic_url;
    @ManyToMany
    private List<Event> events;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Babysitter> babysitters;
}
