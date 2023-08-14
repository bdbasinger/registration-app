package com.basinger.registrationapp.controllers;

import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//API Controller
@RequestMapping("/api")
@RestController
public class PlayerController {

    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players/id/{id}")
    //@ResponseBody //This means JSON will be returned
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/players/profession/{profession}")
    //@ResponseBody
    public List<Player> getPlayerByProfession(@PathVariable String profession) {
        return playerService.getPlayersByProfession(profession);
    }



    /*
    @PostMapping("/registerPlayer")
public String registerPlayer(Player player) {
    // Spring automatically binds form data to the Player object
    ...
}


The @RequestBody annotation is commonly used with @RestController in Spring when you're working with JSON or XML payloads in the request body. It tells Spring to parse the body of the HTTP request and convert it into a Java object.

In the example provided, the form's data is sent as application/x-www-form-urlencoded by default, which means it's formatted like a typical URL's query string (e.g., key1=value1&key2=value2). This is the default encoding for HTML forms. In such cases, using @ModelAttribute (either implicitly or explicitly) is the norm, and it tells Spring to bind form parameters to a bean.

However, if you're building an API and your client sends JSON payload in the request body, you would use @RequestBody.

Here's a comparison for clarity:

Form-based submission (typically used with Thymeleaf, JSP, etc.):
java
Copy code
@PostMapping("/registerPlayer")
public String registerPlayer(Player player) {
    // Spring automatically binds form data to the Player object
    ...
}
JSON payload submission (commonly used for APIs):
java
Copy code
@PostMapping("/api/registerPlayer")
public ResponseEntity<Player> registerApiPlayer(@RequestBody Player player) {
    // Spring binds the JSON payload to the Player object
    ...
}
In the context of a Thymeleaf form and a regular @Controller, you generally don't need @RequestBody. Just using the bean (Player in this case) as a method parameter should suffice.


@PostMapping("/api/registerPlayer")
public ResponseEntity<Player> registerApiPlayer(@RequestBody Player player) {
    // Spring binds the JSON payload to the Player object
    ...
}

     */




}
