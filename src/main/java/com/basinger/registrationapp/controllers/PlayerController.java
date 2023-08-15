package com.basinger.registrationapp.controllers;

import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController is a combination of @Controller and @ResponseBody

// Using @Controller annotation above class declaration
// (requires @ResponseBody for methods that aren't returning views):

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

    @ResponseBody
    @GetMapping("/api/list/bycity")
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

    /*

    @RequestBody in the method parameters indicates that
    it expects to receive JSON requests
    and returns a simple JSON or plain text response

    It's not intended for traditional web form submissions.
    Traditional web forms typically submit data in a
    application/x-www-form-urlencoded format rather than as JSON.

    It's intended for API clients or frontend JavaScript frameworks/libraries.
    For example, if you're using a frontend framework like React, Vue, or Angular,
    or if you have mobile apps or other third-party applications that need to send player data,
    they'd send a JSON-formatted POST request to /api/register

    const playerData = {
    name: "John Doe",
    // other player fields...
};

fetch("/api/register", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(playerData)
})
.then(response => response.text())
.then(data => {
    console.log(data);  // This should log "Player registered successfully."
})
.catch(error => {
    console.error("Error:", error);
});





     */
    @ResponseBody
    @PostMapping("/api/register")
    public Player registerPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player;

    }

    @PostMapping("/register")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/list";
    }

    @ResponseBody
    @GetMapping("/list/id/{id}")
    //@ResponseBody //This means JSON will be returned
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @ResponseBody
    @GetMapping("/api/list/profession/{profession}")
    //@ResponseBody
    public List<Player> getPlayerByProfession(@PathVariable String profession) {
        return playerService.getPlayersByProfession(profession);
    }


}

