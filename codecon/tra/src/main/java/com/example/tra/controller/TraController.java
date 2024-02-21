package com.example.tra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.tra.model.Tra;
import com.example.tra.service.TraService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class TraController {
    @Autowired
    TraService traService;
    @PostMapping("/add")
    public ResponseEntity<Tra> addTra(@RequestBody Tra p) {
        
        return new ResponseEntity<>(traService.addTra(p),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public List<Tra>getTra() {
        return traService.getTra();
    }
    @GetMapping("/get/{id}")
    public Optional<Tra>getTraById(@PathVariable Long id) {
        return traService.getTraById(id);
    }
    @PutMapping("edit/{id}")
    public Tra editTra(@PathVariable Long id, @RequestBody Tra p) {
        return traService.editTra(id, p);
    }
    @DeleteMapping("/del/{id}")
    public String delTra(@PathVariable Long id)
    {
        return traService.delTra(id);
    }
    
}
