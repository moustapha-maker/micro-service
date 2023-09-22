package com.example.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr",discriminatorType = DiscriminatorType.STRING,length = 3)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public abstract class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String cin ;
    @NonNull
    private String nom ;
    @NonNull
    private String prenom;
    @NonNull @Temporal(TemporalType.DATE)
    private Date dateNaissence ;
    @NonNull
    private byte[] photo ;
    @NonNull
    private String cv ;
    @NonNull
    private String email;
    @NonNull
    private String password ;


}
