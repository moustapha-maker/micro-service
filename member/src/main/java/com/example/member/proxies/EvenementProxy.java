package com.example.member.proxies;

import com.example.member.entity.EvenementBean;
import com.example.member.entity.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxy {

    @GetMapping("/evenements/{id}")
    EvenementBean findEvenementById(@PathVariable(name = "id") Long id);
}


