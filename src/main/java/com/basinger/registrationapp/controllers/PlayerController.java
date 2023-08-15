package com.basinger.registrationapp.controllers;

import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.services.PlayerService;
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


    @GetMapping("/list")
    public String getAllPlayers(Model model) {
        List<Player> playerList = playerService.getAllPlayers();
        model.addAttribute("player", playerList);
        return "list";
        // This is the name of the html template found in /resources/templates
    }

    @GetMapping("/list/bycity")
    public List<Player> getPlayersByCity(@RequestParam String city) {
        return playerService.getPlayersByCity(city);
    }


    @PostMapping("/update")
    public String updatePlayer(@ModelAttribute Player player, Model model) {
        playerService.updatePlayer(player);
        model.addAttribute("player", player);
        return "redirect:/list";  // redirect back to the list page or wherever you want
    }

    // Endpoint to show the form pre-filled with player's data
    @GetMapping("/edit/{id}")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        return "edit";  // This is the name of your Thymeleaf template
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "redirect:/list";  // redirect back to the list page or wherever you want
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("player", new Player());
        return "register";
    }

    @PostMapping("/register")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/list";
    }

    @GetMapping("/list/id/{id}")
    //@ResponseBody //This means JSON will be returned
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }


    @GetMapping("/list/profession/{profession}")
    //@ResponseBody
    public List<Player> getPlayerByProfession(@PathVariable String profession) {
        return playerService.getPlayersByProfession(profession);
    }


}

