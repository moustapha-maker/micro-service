package com.example.outilservice.service;

import com.example.outilservice.dao.OutilRepository;
import com.example.outilservice.entity.Outil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OutilImpl  implements IOutilService{
    private OutilRepository outilRepository ;


    @Override
    public Outil addOutil(Outil o) {
        return outilRepository.save(o);
    }

    @Override
    public void deleteOutil(Long id) {
      outilRepository.deleteById(id);
    }

    @Override
    public Outil updateOutil(Outil o) {
        return outilRepository.save(o);
    }

    @Override
    public Outil findOutil(Long id) {
        return outilRepository.findById(id).get();
    }

    @Override
    public List<Outil> findAll() {
        return outilRepository.findAll();
    }

    @Override
    public Outil findBysource(String source) {
        return outilRepository.findBySource(source);
    }

    @Override
    public Outil findByDate(Date date) {

        return outilRepository.findByDate(date);
    }
}
