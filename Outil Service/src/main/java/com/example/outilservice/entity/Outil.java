package com.example.outilservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Outil

{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date date ;
    @NonNull
    private  String source;



}
