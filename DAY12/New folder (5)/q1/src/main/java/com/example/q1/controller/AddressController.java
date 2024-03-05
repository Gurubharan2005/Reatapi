package com.example.q1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.q1.model.Address;
import com.example.q1.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
     AddressService addressService;

    @PostMapping("/employee/{id}")
    public ResponseEntity<Address> addAddressToEmployee(@PathVariable int id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.postAddress(id, address), HttpStatus.CREATED);
    }
}
