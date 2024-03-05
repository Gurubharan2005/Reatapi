package com.example.ce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ce1.model.Address;

import jakarta.transaction.Transactional;
@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{   
}