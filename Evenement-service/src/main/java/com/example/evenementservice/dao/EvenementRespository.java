package com.example.evenementservice.dao;

import com.example.evenementservice.entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface EvenementRespository extends JpaRepository<Evenement,Long> {
    List<Evenement> findByLieu(String lieu);
    Evenement findByTitre(String titre);
}
