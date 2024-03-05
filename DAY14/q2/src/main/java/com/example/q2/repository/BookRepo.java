package com.example.q2.repository;


import com.example.q2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}
