package com.cursesalura.challengeliterature;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursesalura.challengeliterature.main.Principal;

@SpringBootApplication
public class ChallengeliteratureApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ChallengeliteratureApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.menu();
    }
}