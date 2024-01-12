package com.example.member.controllers;

import com.example.member.entity.EnseignantChercheur;
import com.example.member.entity.Etudiant;
import com.example.member.entity.Member;
import com.example.member.services.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MemberRestController {

    IMemberService memberService;
    @RequestMapping(value="/membres", method= RequestMethod.GET)
    public List<Member> findMembres (){
        return memberService.findAll();
    }
    @GetMapping(value="/membres/{id}")
    public Member findOneMemberById(@PathVariable Long id){
        return memberService.findMember(id);
    }

    @GetMapping(value="/membres/search/cin")
    public Member findOneMemberByCin(@RequestParam String cin)
    {
        return memberService.findByCin(cin);
    }
    @GetMapping(value="/membres/search/email")
    public Member findOneMemberByEmail(@RequestParam String email){
        return memberService.findByEmail(email);
    }

    @PostMapping(value="/membres/enseignant")
    public Member addMembre(@RequestBody EnseignantChercheur m)
    {
        return memberService.addMember(m);
    }
    @GetMapping(value="/membres/affectStudentToProf/{idProf}/{idEtud}")
    public void affectStudentToProf(@PathVariable("idProf") Long idProf ,@PathVariable("idEtud") Long idEtud)
    {
          memberService.affecterStudentToProf(idProf,idEtud);
    }
    @GetMapping(value="/membres/affectArticleToMember/{idProf}/{idPub}")
    public void affectArticleToMember(@PathVariable("idProf") Long idProf ,@PathVariable("idPub") Long idPub)
    {
        memberService.affecterauteurTopublication(idProf,idPub);
    }

    @PostMapping(value="/membres/etudiant")
    public Member addMembre(@RequestBody Etudiant e)
    {
        return memberService.addMember(e);
    }

    @DeleteMapping(value="/membres/{id}")
    public void deleteMembre(@PathVariable Long id)
    {
        memberService.deleteMember(id);
    }
    @PutMapping(value="/membres/etudiant/{id}")
    public Member updatemembre(@PathVariable Long id, @RequestBody Etudiant p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }
    @PutMapping(value="/membres/enseignant/{id}")
    public Member updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p)
    {
        p.setId(id);
        return memberService.updateMember(p);
    }

    @GetMapping("/fullmember/{id}")
    public Member findAFullMember(@PathVariable(name="id") Long id){
        Member mbr=memberService.findMember(id);
        mbr.setPubs(memberService.findPublicationparauteur(id));
        mbr.setEvents(memberService.findEventparauteur(id));
        mbr.setOutils(memberService.findOutilparauteur(id));
        return mbr;
    }
}
