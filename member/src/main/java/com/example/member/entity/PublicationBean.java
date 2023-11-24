package com.example.member.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;



@Data
public class PublicationBean {
    private Long id;

    private String type;
    private String titre;
    private Date date;
    private String lien;
    private String sourcepdf ;
}

