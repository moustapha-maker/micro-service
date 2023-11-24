package com.example.member.proxies;

import com.example.member.entity.PublicationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "PUBLICATION-SERVICE")
public interface PublicationProxy {

    @GetMapping("/publications/{id}")
    public   PublicationBean findPublicationById(@PathVariable(name = "id") Long id);
}


