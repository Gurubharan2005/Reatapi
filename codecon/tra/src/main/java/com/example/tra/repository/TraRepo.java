package com.example.tra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tra.model.Tra;

@Repository
public interface TraRepo extends JpaRepository<Tra, Long>{

    
}
