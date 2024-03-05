package com.example.q2.service;

import com.example.q2.model.Book;
import com.example.q2.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(int bookId) {
        return bookRepo.findById(bookId).orElse(null);
    }

    public Book createOrUpdateBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBook(int bookId) {
        bookRepo.deleteById(bookId);
    }
}
