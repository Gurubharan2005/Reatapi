package com.example.q2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.q2.model.Book;
import com.example.q2.service.BookService;
@RequestMapping("/api/book")
@RestController
public class BookController {
@Autowired
private BookService bookService;

@PostMapping
public ResponseEntity<Book> createBook(@RequestBody Book book) {
    Book createdBook = bookService.createOrUpdateBook(book);
    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
}

@PutMapping("/{bookId}")
public ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book book) {
    Book existingBook = bookService.getBookById(bookId);
    if (existingBook == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    book.setBookId(bookId);
    Book updatedBook = bookService.createOrUpdateBook(book);
    return new ResponseEntity<>(updatedBook, HttpStatus.OK);
}

@GetMapping
public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.getAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
}

@GetMapping("/{bookId}")
public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
    Book book = bookService.getBookById(bookId);
    if (book == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(book, HttpStatus.OK);
}

@DeleteMapping("/{bookId}")
public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
    Book book = bookService.getBookById(bookId);
    if (book == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    bookService.deleteBook(bookId);
    return new ResponseEntity<>(HttpStatus.OK);
}

    
}