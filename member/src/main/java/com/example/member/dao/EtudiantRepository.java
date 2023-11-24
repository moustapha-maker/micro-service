package com.example.member.dao;

import com.example.member.entity.EnseignantChercheur;
import com.example.member.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant ,Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
    List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
}
