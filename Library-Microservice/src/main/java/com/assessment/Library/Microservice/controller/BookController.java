package com.assessment.Library.Microservice.controller;

import com.assessment.Library.Microservice.model.Book;
import com.assessment.Library.Microservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> filterBooks(
            @RequestParam String genre,
            @RequestParam String author,
            @RequestParam String status) {
        return ResponseEntity.ok(bookService.filterBooks(genre, author, status));
    }
}

