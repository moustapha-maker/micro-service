package com.example.member.dao;

import com.example.member.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreEvenementRepository extends JpaRepository<Membre_Evenement, Membre_Evenement_Id> {

    List<Membre_Evenement> findByAuteur(Member auteur);
}