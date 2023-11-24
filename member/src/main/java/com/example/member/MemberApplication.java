package com.example.member;

import com.example.member.dao.*;
import com.example.member.entity.*;
import com.example.member.proxies.EvenementProxy;
import com.example.member.proxies.OutilProxy;
import com.example.member.proxies.PublicationProxy;
import com.example.member.services.MemberImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class MemberApplication  implements CommandLineRunner {
    MemberRepository membreRepository;
    MemberImpl  memberService;
    PublicationProxy publicationProxy ;
    OutilProxy outilProxy;
    EvenementProxy evenementProxy ;
    MembrePubRepository membrePubRepository;
    MembreOutilRepository membreOutilRepository;
    MembreEvenementRepository membreEvenementRepository;
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EnseignantChercheur  enseignantChercheur1= new EnseignantChercheur("35155212","amjed","jlasi",new Date(),new byte[0],"------","jlasi@gmail","1234","docteur","enis");

        EnseignantChercheur  enseignantChercheur2= new EnseignantChercheur("2035623","slim","trablusi",new Date(),new byte[0],"+++++++","trabulsi@gmail","1234","docteur","enis");


        enseignantChercheur1=  membreRepository.save(enseignantChercheur1);
        enseignantChercheur2 =  membreRepository.save(enseignantChercheur2);

        PublicationBean pub = publicationProxy.findPublicationById(1L);
        PublicationBean pub2 = publicationProxy.findPublicationById(2L);
        PublicationBean pub3 = publicationProxy.findPublicationById(3L);
        memberService.affecterauteurTopublication(enseignantChercheur1.getId(),pub.getId());
        memberService.affecterauteurTopublication(enseignantChercheur1.getId(),pub2.getId());
        memberService.affecterauteurTopublication(enseignantChercheur1.getId(),pub3.getId());


        OutilBean out = outilProxy.findOutilById(1L);
        memberService.affecterauteurToOutil(enseignantChercheur1.getId(),out.getId());


        EvenementBean event = evenementProxy.findEvenementById(1L);
        memberService.affecterauteurToevnement(enseignantChercheur1.getId(),event.getId());




        Etudiant etudiant1 = new Etudiant("351511","abdo","sidi",new Date(),new byte[0],"********","sidi@gmail","1234",new Date(),"master","IA appliquer sur finance",enseignantChercheur1);
        Etudiant etudiant2= new Etudiant("351511","samir","salem",new Date(),new byte[0],"********","samir@gmail","1234",new Date(),"ingenieur","blockchain ",enseignantChercheur2);

        membreRepository.save(etudiant1);
        membreRepository.save(etudiant2);


        for (Member member: membreRepository.findAll()
             ) {
            System.out.println(member.getNom() +" "+ member.getPrenom() + "" + member.getId() +" : "+ member.getClass().getName());
        }





    }
}
