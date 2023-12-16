package com.basinger.registrationapp.config;



import com.basinger.registrationapp.models.Player;
import com.basinger.registrationapp.repos.PlayerRepository;
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
        this.repository.save(new Player("Brennan", "","","","","","Software Engineer"));
        this.repository.save(new Player("David", "","","","","","Dentist"));
        this.repository.save(new Player("Lacy", "","","","","","Sales"));
        this.repository.save(new Player("Audrey", "","","Memphis","","","Sales"));
        this.repository.save(new Player("Meredith", "","","","","","Teacher"));
        this.repository.save(new Player("Fran", "","","Memphis","","","Nurse"));
        this.repository.save(new Player("Jessi", "","","","","","Insurance"));
        this.repository.save(new Player("Rusty", "","","","","","Lawyer"));

    }
}
