package com.example.member.proxies;

import com.example.member.entity.OutilBean;
import com.example.member.entity.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "OUTIL-SERVICE")
public interface OutilProxy {

    @GetMapping("/outils/{id}")
    OutilBean findOutilById(@PathVariable(name = "id") Long id);
}


