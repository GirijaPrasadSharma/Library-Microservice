package com.assessment.Library.Microservice.service;

import com.assessment.Library.Microservice.model.Book;
import com.assessment.Library.Microservice.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        book.setStatus("Available");
        return bookRepository.save(book);
    }

    public List<Book> filterBooks(String genre, String author, String status) {
        return bookRepository.findByGenreAndAuthorAndStatus(genre, author, status);
    }
}
