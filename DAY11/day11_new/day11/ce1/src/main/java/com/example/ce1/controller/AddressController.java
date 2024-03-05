package com.example.ce1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.Address;
import com.example.ce1.model.Person;
import com.example.ce1.repository.PersonRepo;
import com.example.ce1.service.AddressService;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
@Autowired
PersonRepo obj1;
    @PostMapping("/address/person/{personId}")
    public ResponseEntity<Address> setMethod(@RequestBody Address address,@PathVariable long personId)
    {
        return new ResponseEntity<>(addressService.setAddress(address,personId),HttpStatus.CREATED);
    }
}
