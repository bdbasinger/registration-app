package com.basinger.todolistapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByProfession(String profession);
    Optional<Player> findPlayerById(Long id);

}
