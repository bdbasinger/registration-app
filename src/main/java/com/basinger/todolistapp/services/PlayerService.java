package com.basinger.todolistapp.services;

import com.basinger.todolistapp.Player;
import com.basinger.todolistapp.PlayerRepository;
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
            throw new IllegalStateException("Player Not Found For Player With ID: " + id);
        }
    }
}
