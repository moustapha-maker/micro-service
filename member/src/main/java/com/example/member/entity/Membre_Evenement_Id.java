package com.example.member.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membre_Evenement_Id implements Serializable {
    private Long Evenement_id;
    private Long auteur_id;
}