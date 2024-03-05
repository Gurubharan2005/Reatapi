package com.example.q2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.q2.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
