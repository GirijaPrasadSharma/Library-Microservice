package com.assessment.Library.Microservice.repo;

import com.assessment.Library.Microservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenreAndAuthorAndStatus(String genre, String author, String status);
}
