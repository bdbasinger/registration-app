package com.basinger.registrationapp.repos;

import com.basinger.registrationapp.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByProfession(String profession);
    Optional<Player> findPlayerById(Long id);

}
