package com.cursesalura.challengeliterature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cursesalura.challengeliterature.main.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import com.cursesalura.challengeliterature.repository.*;

@SpringBootApplication
public class ChallengeliteratureApplication implements CommandLineRunner {

    @Autowired
    BookRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(ChallengeliteratureApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repository);
        principal.menu();
    }
}
