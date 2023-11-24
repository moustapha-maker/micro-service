package com.example.publicationservice;

import com.example.publicationservice.dao.PublicationRepository;
import com.example.publicationservice.entity.Publication;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class PublicationServiceApplication implements CommandLineRunner {
   PublicationRepository publicationRepository;
    RepositoryRestConfiguration configuration;
    public static void main(String[] args) {
        SpringApplication.run(PublicationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        configuration.exposeIdsFor(Publication.class);

        Publication pubs1= new Publication("article", "an approach for testing soa systems", new Date(), "lien", "pdf");
        Publication pubs2= new Publication("chapitre de livre", "towards cloud computing : issues and challenges",new Date(), "lien", "pdf");
        Publication pubs3= new Publication("article","introducing blochainsystems", new Date(), "lien", "pdf");
        publicationRepository.save(pubs1);
        publicationRepository.save(pubs2);
        publicationRepository.save(pubs3);

    }
}
