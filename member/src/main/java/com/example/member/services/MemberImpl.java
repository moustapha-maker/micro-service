package com.example.member.services;

import com.example.member.dao.EnseignantChercheurRepository;
import com.example.member.dao.EtudiantRepository;
import com.example.member.dao.MemberRepository;
import com.example.member.entity.EnseignantChercheur;
import com.example.member.entity.Etudiant;
import com.example.member.entity.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberImpl implements  IMemberService{

    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;
    public Member addMember(Member m) {
        memberRepository.save(m);
        return m;
    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
    public Member updateMember(Member m) {
        return memberRepository.saveAndFlush(m);
    }
    public Member findMember(Long id) {
        Member m = (Member) memberRepository.findById(id).get();
        return m;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();}
    public Member findByCin(String cin) {
        return memberRepository.findByCin(cin);}
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);}
    public List<Member> findByNom(String nom) {
        return memberRepository.findByNom(nom);
    }
    public List<Etudiant> findByDiplome(String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }
    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    public void affecter_EtudiantToEnseignant(Long idEtudiant ,Long idEnseignant){
         Etudiant etud1 = etudiantRepository.findById(idEtudiant).get();
        EnseignantChercheur  ens1 = enseignantChercheurRepository.findById(idEnseignant).get();
        etud1.setEncadrant(ens1);
        etudiantRepository.save(etud1);
    }
}
