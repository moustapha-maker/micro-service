package com.example.publicationservice.dao;
import com.example.publicationservice.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    List<Publication> findByType(String lieu);
    Publication findByTitre(String titre);
}
