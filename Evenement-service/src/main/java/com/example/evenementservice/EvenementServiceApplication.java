package com.example.evenementservice;

import com.example.evenementservice.dao.EvenementRespository;
import com.example.evenementservice.entity.Evenement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class EvenementServiceApplication implements CommandLineRunner {
   EvenementRespository evenementRespository;
    RepositoryRestConfiguration configuration;
    public static void main(String[] args) {
        SpringApplication.run(EvenementServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        configuration.exposeIdsFor(Evenement.class);
        Evenement ev= new Evenement("event 1",new Date(),"sfax");
        Evenement ev2= new Evenement("event 2",new Date(),"Tunis");
        evenementRespository.save(ev);
        evenementRespository.save(ev2);
    }
}
