package com.example.outilservice.dao;

import com.example.outilservice.entity.Outil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;

@RepositoryRestController
public interface OutilRepository extends JpaRepository<Outil ,Long> {
    Outil findBySource(String source);
    Outil findByDate(Date date);
}
