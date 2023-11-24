package com.example.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Member {
    @Temporal(TemporalType.DATE)
    private Date dateInscription ;
    private String diplome ;
    private String sujet;

    @JoinColumn(name = "chercheur_id")
    @JsonBackReference
    @ManyToOne EnseignantChercheur encadrant;

    @Builder
    public Etudiant(@NonNull String cin, @NonNull String Nom, @NonNull String prenom, @NonNull Date dateNaissence, @NonNull byte[] photo, @NonNull String cv, @NonNull String email, @NonNull String password, Date dateInscription, String diplome, String sujet, EnseignantChercheur encadrant) {
        super(cin, Nom, prenom, dateNaissence, photo, cv, email, password);
        this.dateInscription = dateInscription;
        this.diplome = diplome;
        this.sujet = sujet;
        this.encadrant = encadrant;
    }
}
