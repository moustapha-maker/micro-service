package com.example.publicationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@RequiredArgsConstructor

public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String type;
    @NonNull
    private String titre;

    @NonNull    @Temporal(TemporalType.DATE)
    private Date date;
    @NonNull
    private String lien;
    @NonNull
    private String sourcepdf ;
}
