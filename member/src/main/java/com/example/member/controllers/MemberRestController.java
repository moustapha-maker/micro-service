package com.example.member.controllers;

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
    }}
