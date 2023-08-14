package com.basinger.registrationapp.services;

import com.basinger.registrationapp.PlayerException;
import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();

    }

    public Player getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findPlayerById(id);
        if (player.isPresent()) {
            return player.get();
        } else {
            throw new PlayerException("Player Not Found For Player With ID: " + id);
        }
    }


    // The thymeleaf template uses

    // <form th:action="@{/savePlayer}" th:object="${player}" method="post">
    // In the thymeleaf template, savePlayer corresponds to @PostMapping("/registerPlayer") endpoint
    // But it "savePlayer

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }


    public List<Player> getPlayersByProfession(String profession) {
        List<Player> playerList = playerRepository.findPlayersByProfession(profession);
        if (playerList.isEmpty())
            throw new PlayerException("No registered players found with profession: " + profession);
        else
            return playerList;

    }

}


