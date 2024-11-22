package com.assessment.Library.Microservice;

import com.assessment.Library.Microservice.model.Book;
import com.assessment.Library.Microservice.repo.BookRepository;
import com.assessment.Library.Microservice.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void addBookTest() {
        Book book = new Book(1L, "Title", "Author", "Genre", LocalDate.now(), "Available");

        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

        Book savedBook = bookService.addBook(book);

        Assertions.assertNotNull(savedBook);
        Assertions.assertEquals("Title", savedBook.getTitle());
    }
}