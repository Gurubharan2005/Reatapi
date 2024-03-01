package com.example.q3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.q3.model.Language;
@Repository
public interface LanguageRepo extends JpaRepository<Language,Integer> {
    
}
