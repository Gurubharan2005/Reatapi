package com.example.q2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class Book {
    @Id
    private int bookId;
    private String title;
    private String author;
    private int availableCopies;
    private int totalCopies;

}
