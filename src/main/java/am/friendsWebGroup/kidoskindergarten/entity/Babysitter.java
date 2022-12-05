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
@Table(name = "babySitter")

public class Babysitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    @ManyToMany
    private List<Kid> kids;
    @Enumerated(value = EnumType.STRING)
    private Experience experience;
    @ManyToOne
    private Training training;
    private String pic_url;
}
