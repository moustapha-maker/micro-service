package com.example.member.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EvenementBean {
        private Long id;
        private String  title;
        private Date date;
        private String lieu ;
    }