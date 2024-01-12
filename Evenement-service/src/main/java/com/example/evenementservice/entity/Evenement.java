package com.example.evenementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@RequiredArgsConstructor

public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @NonNull    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @NonNull
    private String lieu ;
}
