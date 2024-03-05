package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.Address;
import com.example.ce1.model.Person;
import com.example.ce1.repository.AddressRepo;
import com.example.ce1.repository.PersonRepo;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    PersonRepo personRepo;
    public Address setAddress(Address address,long personId)
    {
       Person person=personRepo.findById(personId).orElse(null);
       if(person!=null)
       {
        person.setAddress(address);
        return addressRepo.save(address);
       }
       else{
        return null;
       }
    }
}
