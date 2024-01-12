package com.example.member.services;

import com.example.member.entity.*;

import java.util.List;

public interface IMemberService {

    public Member addMember(Member m);
    public void deleteMember(Long id) ;
    public Member updateMember(Member p) ;
    public Member findMember(Long id) ;
    public List<Member> findAll();
    //Filtrage par propriété
    public Member findByCin(String cin);
    public Member findByEmail(String email);
    public List<Member> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur encadrant);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);
    public void affecterauteurTopublication(Long idauteur, Long idpub);
    public void affecterStudentToProf(Long idProf, Long idEtud);
    public void affecterauteurToevnement(Long idauteur, Long idpub)  ;
    public void affecterauteurToOutil(Long idauteur, Long idpub) ;
    public List<PublicationBean>
    findPublicationparauteur (Long idauteur);

    public List<EvenementBean> findEventparauteur(Long idauteur);
    public List<OutilBean> findOutilparauteur(Long idauteur);
}
