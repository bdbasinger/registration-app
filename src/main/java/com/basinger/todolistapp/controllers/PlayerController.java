package com.basinger.todolistapp.controllers;

import com.basinger.todolistapp.Player;
import com.basinger.todolistapp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PlayerController {
    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /*
//playerList is the data that I'm actually adding to the model
//player is the name of the variable that I put in ${...} within the thymeleaf template
//<tr th:each="p : ${player}
//p is what I decided to use when trying to get player attributes
//p.id
//p.firstName
//p.profession etc...
 */
    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        List<Player> playerList = playerService.getAllPlayers();
        model.addAttribute("player", playerList);
        return "show"; // This is the name of the html template found in /resources/templates
    }

    @GetMapping("/players/{id}")
    @ResponseBody //This means JSON will be returned
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }







}
