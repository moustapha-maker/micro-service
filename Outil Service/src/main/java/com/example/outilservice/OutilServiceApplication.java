package com.example.outilservice;

import com.example.outilservice.dao.OutilRepository;
import com.example.outilservice.entity.Outil;
import com.example.outilservice.service.IOutilService;
import com.example.outilservice.service.OutilImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class OutilServiceApplication implements CommandLineRunner {
    private OutilRepository outilRepository ;
    RepositoryRestConfiguration configuration;
    public static void main(String[] args) {
        SpringApplication.run(OutilServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        configuration.exposeIdsFor(Outil.class);
        Outil outil = new Outil(new Date(),"source1");
        Outil outil2 = new Outil(new Date(),"source2");
        Outil outil3 = new Outil(new Date(),"source3");
        outilRepository.save(outil);
        outilRepository.save(outil2);
        outilRepository.save(outil3);
    }
}
