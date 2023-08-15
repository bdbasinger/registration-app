package com.basinger.registrationapp.repos;

import com.basinger.registrationapp.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findPlayersByProfession(String profession);
    List<Player> findPlayersByCity(String city);

    Optional<Player> findPlayerById(Long id);
}
