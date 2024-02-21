package com.example.tra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tra.model.Tra;
import com.example.tra.repository.TraRepo;

@Service
public class TraService {
    @Autowired
    TraRepo traRepo;
    public Tra addTra(Tra p){
        return traRepo.save(p);
    }
    public List<Tra>getTra(){
        return traRepo.findAll();
    }
    public Optional<Tra> getTraById(Long id){
        return traRepo.findById(id);
    }
    public Tra editTra(Long id,Tra p)
    {
        Tra traAvail=traRepo.findById(id).orElse(null);
        if(traAvail!=null){
            traAvail.setName(p.getName());
            traAvail.setFromLocation(p.getFromLocation());
            traAvail.setToLocation(p.getToLocation());
            return traRepo.saveAndFlush(p);
        }
        else
        return null;
    }
    public String delTra(Long id){
        traRepo.deleteById(id);
        return("User deleted");
    }
}
