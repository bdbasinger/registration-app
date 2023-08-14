package com.basinger.registrationapp.controllers;

import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// View Controller -  returns thymeleaf template views
@Controller
public class PlayerViewController {

    @Autowired
    private PlayerService playerService;

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
        return "show";
        // This is the name of the html template found in /resources/templates
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("player", new Player());
        return "register";
    }

    @PostMapping("/registerPlayer")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/players";
    }






}
