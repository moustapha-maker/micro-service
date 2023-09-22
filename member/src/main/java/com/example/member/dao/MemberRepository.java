package com.example.member.dao;

import com.example.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository  extends JpaRepository<Member,Long> {
    Member findByCin(String cin);
    List<Member> findByNomStartingWith(String caractere);
    Member findByEmail(String email);
    List<Member> findByNom(String email);
}
