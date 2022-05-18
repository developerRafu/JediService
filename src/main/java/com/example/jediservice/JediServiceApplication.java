package com.example.jediservice;

import com.example.jediservice.models.Jedi;
import com.example.jediservice.models.enums.Status;
import com.example.jediservice.repoistories.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JediServiceApplication implements CommandLineRunner {
@Autowired
private JediRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(JediServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Jedi> jedis = new ArrayList<>();
        Jedi jedi = new Jedi();
        jedi.setMidichlorians(9000);
        jedi.setName("Rafu");
        jedi.setStatus(Status.MESTRE);
        jedi.setMestre("Nobody");
        jedis.add(jedi);
        repository.saveAll(jedis);
    }
}
