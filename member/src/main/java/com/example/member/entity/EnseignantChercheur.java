package com.example.member.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("ens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnseignantChercheur extends Member {

    private String grade ;
    private String etablissement ;

    @Builder
    public EnseignantChercheur(@NonNull String cin, @NonNull String Nom, @NonNull String prenom, @NonNull Date dateNaissence, @NonNull byte[] photo, @NonNull String cv, @NonNull String email, @NonNull String password, String grade, String etablissement) {
        super(cin, Nom, prenom, dateNaissence, photo, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }
}
