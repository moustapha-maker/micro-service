package com.example.member.services;

import com.example.member.dao.*;
import com.example.member.entity.*;
import com.example.member.proxies.EvenementProxy;
import com.example.member.proxies.OutilProxy;
import com.example.member.proxies.PublicationProxy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberImpl implements  IMemberService{

    MemberRepository memberRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;
    MembrePubRepository membrePubRepository;
    MembreEvenementRepository membreEvenementRepository;
    MembreOutilRepository membreOutilRepository;
    PublicationProxy publicationProxy ;
    EvenementProxy evenementProxy;
    OutilProxy outilProxy;


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

    @Override
    public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur encadrant) {
        return etudiantRepository.findByEncadrant(encadrant);
    }

    public List<EnseignantChercheur> findByGrade(String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    @Override
    public void affecterauteurTopublication(Long idauteur, Long idpub) {
        Member mbr= memberRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrePubRepository.save(mbs);
    }

    @Override
    public void affecterauteurToevnement(Long idauteur, Long idpub) {
        Member mbr= memberRepository.findById(idauteur).get();
        Membre_Evenement mbs= new Membre_Evenement();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Evenement_Id(idpub, idauteur));
        membreEvenementRepository.save(mbs);
    }

    @Override
    public void affecterauteurToOutil(Long idauteur, Long idpub) {
        Member mbr= memberRepository.findById(idauteur).get();
        Membre_Outil mbs= new Membre_Outil();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Outil_Id(idpub, idauteur));
        membreOutilRepository.save(mbs);
    }
    @Override
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Member auteur= memberRepository.findById(idauteur).get();
        List< Membre_Publication>
                idpubs=membrePubRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
            System.out.println(s);
            pubs.add(publicationProxy.findPublicationById(s.getId().getPublication_id()));}
        );
        return pubs;
    }

    @Override
    public List<EvenementBean> findEventparauteur(Long idauteur) {
        List<EvenementBean> pubs=new ArrayList<EvenementBean>();
        Member auteur= memberRepository.findById(idauteur).get();
        List<Membre_Evenement>
                idpubs=membreEvenementRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
            System.out.println(s);
            pubs.add(evenementProxy.findEvenementById(s.getId().getEvenement_id()));}
        );
        return pubs;
    }

    @Override
    public List<OutilBean> findOutilparauteur(Long idauteur) {
        List<OutilBean> pubs=new ArrayList<OutilBean>();
        Member auteur= memberRepository.findById(idauteur).get();
        List<Membre_Outil>
                idpubs=membreOutilRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
            System.out.println(s);
            pubs.add(outilProxy.findOutilById(s.getId().getOutil_id()));}
        );
        return pubs;
    }
    public void affecter_EtudiantToEnseignant(Long idEtudiant ,Long idEnseignant){
         Etudiant etud1 = etudiantRepository.findById(idEtudiant).get();
        EnseignantChercheur  ens1 = enseignantChercheurRepository.findById(idEnseignant).get();
        etud1.setEncadrant(ens1);
        etudiantRepository.save(etud1);
    }

}
