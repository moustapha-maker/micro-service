package com.example.outilservice.service;

import com.example.outilservice.entity.Outil;

import java.util.Date;
import java.util.List;

public interface IOutilService {


    public Outil addOutil(Outil o);
    public void deleteOutil(Long id) ;
    public Outil updateOutil(Outil o) ;
    public Outil findOutil(Long id) ;
    public List<Outil> findAll();
    //Filtrage par propriété
    public Outil findBysource(String source);
    public Outil findByDate(Date date);

}
