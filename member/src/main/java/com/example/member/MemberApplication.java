package com.example.member;

import com.example.member.dao.EnseignantChercheurRepository;
import com.example.member.dao.MemberRepository;
import com.example.member.entity.EnseignantChercheur;
import com.example.member.entity.Etudiant;
import com.example.member.entity.Member;
import com.example.member.services.MemberImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class MemberApplication  implements CommandLineRunner {
    MemberRepository membreRepository;
    MemberImpl  memberService;
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EnseignantChercheur  enseignantChercheur1= new EnseignantChercheur("35155212","amjed","jlasi",new Date(),new byte[0],"------","jlasi@gmail","1234","docteur","enis");
        enseignantChercheur1=  membreRepository.save(enseignantChercheur1);
        EnseignantChercheur  enseignantChercheur2= new EnseignantChercheur("2035623","slim","trablusi",new Date(),new byte[0],"+++++++","trabulsi@gmail","1234","docteur","enis");
        enseignantChercheur2 =  membreRepository.save(enseignantChercheur2);

        Etudiant etudiant1 = new Etudiant("351511","abdo","sidi",new Date(),new byte[0],"********","sidi@gmail","1234",new Date(),"master","IA appliquer sur finance",enseignantChercheur1);
        Etudiant etudiant2= new Etudiant("351511","samir","salem",new Date(),new byte[0],"********","samir@gmail","1234",new Date(),"ingenieur","blockchain ",enseignantChercheur2);

        membreRepository.save(etudiant1);
        membreRepository.save(etudiant2);


        for (Member member: membreRepository.findAll()
             ) {
            System.out.println(member.getNom() +" "+ member.getPrenom() + "" + member.getId() +" : "+ member.getClass().getName());
        }

        System.out.println(membreRepository.findById(3l).get().getNom());



        Member m= memberService.findMember(1L);
        m.setCv("cv1.pdf");
        memberService.updateMember(m);
// Delete a Member
        memberService.deleteMember(3L);
    }
}
