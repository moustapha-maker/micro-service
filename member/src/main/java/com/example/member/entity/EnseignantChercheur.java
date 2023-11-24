package com.example.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("ens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnseignantChercheur extends Member {

    private String grade ;
    private String etablissement ;

    @OneToMany(mappedBy = "encadrant")
    @JsonManagedReference
    List<Etudiant> etds ;

    @Builder
    public EnseignantChercheur(@NonNull String cin, @NonNull String Nom, @NonNull String prenom, @NonNull Date dateNaissence, @NonNull byte[] photo, @NonNull String cv, @NonNull String email, @NonNull String password, String grade, String etablissement) {
        super(cin, Nom, prenom, dateNaissence, photo, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }
}
