package com.basinger.todolistapp;



import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {
    private final PlayerRepository repository;

    @Autowired
    public DatabaseLoader(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(
                new Player("Brennan", "","","","","","Software Engineer"));
                new Player("David", "","","","","","Dentist");
                new Player("Lacy", "","","","","","Sales");
                new Player("Meredith", "","","","","","Teacher");
                new Player("Fran", "","","","","","Nurse");
                new Player("Jessi", "","","","","","Insurance");
                new Player("Rusty", "","","","","","Lawyer");
    }
}
