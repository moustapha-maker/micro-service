package com.example.member.dao;

import com.example.member.entity.Member;
import com.example.member.entity.Membre_Pub_Id;
import com.example.member.entity.Membre_Publication;
import com.example.member.entity.PublicationBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembrePubRepository extends
        JpaRepository<Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Member auteur);

}