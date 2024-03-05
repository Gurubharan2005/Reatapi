package com.example.ce1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.Person;
import com.example.ce1.service.PersonService;

import jakarta.transaction.Transactional;
@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    

    @PostMapping("/person")
    public ResponseEntity<Person> setMethod(@RequestBody Person person)
    {
        return new ResponseEntity<>(personService.setPerson(person),HttpStatus.CREATED);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getMethod()
    {
        return new ResponseEntity<>(personService.getPersons(),HttpStatus.OK);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<Optional<Person>> getMethodbyId(@PathVariable Long personId)
    {
        return new ResponseEntity<>(personService.getPersonId(personId),HttpStatus.OK);
    }

   
}
