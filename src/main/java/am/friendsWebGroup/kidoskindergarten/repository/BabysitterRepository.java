package am.friendsWebGroup.kidoskindergarten.repository;

import am.friendsWebGroup.kidoskindergarten.entity.Babysitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BabysitterRepository extends JpaRepository<Babysitter, Integer> {

    Optional<Babysitter> findByEmail(String email);
}
