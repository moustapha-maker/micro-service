package com.example.member.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EvenementBean {
        private Long id;
        private String titre;
        private Date date;
        private String lieu ;
    }