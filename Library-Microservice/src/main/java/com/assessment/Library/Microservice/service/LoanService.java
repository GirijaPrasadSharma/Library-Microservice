package com.assessment.Library.Microservice.service;

import com.assessment.Library.Microservice.model.Book;
import com.assessment.Library.Microservice.model.Loan;
import com.assessment.Library.Microservice.repo.BookRepository;
import com.assessment.Library.Microservice.repo.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public Loan issueBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (!"Available".equals(book.getStatus())) {
            throw new RuntimeException("Book is not available");
        }
        book.setStatus("Issued");
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBookId(bookId);
        loan.setMemberId(memberId);
        loan.setIssueDate(LocalDate.now());
        loan.setStatus("Issued");
        return loanRepository.save(loan);
    }
}
