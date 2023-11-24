package com.example.member.dao;

import com.example.member.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreOutilRepository extends JpaRepository<Membre_Outil, Membre_Outil_Id> {

    List<Membre_Outil> findByAuteur(Member auteur);
}
