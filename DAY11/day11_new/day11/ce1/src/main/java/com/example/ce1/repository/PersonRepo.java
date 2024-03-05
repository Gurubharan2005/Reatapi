package com.example.ce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ce1.model.Person;
@Repository
public interface PersonRepo extends JpaRepository<Person,Long>{

    
}
