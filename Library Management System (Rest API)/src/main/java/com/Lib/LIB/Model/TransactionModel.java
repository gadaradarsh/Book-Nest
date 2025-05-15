package com.Lib.LIB.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnore
    private BookModel book;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    @JsonIgnore

    private CardModel card;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    public TransactionModel() {}

    public TransactionModel(BookModel book, CardModel card, LocalDate issueDate, LocalDate dueDate) {
        this.book = book;
        this.card = card;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.fine = 0.0;
    }

    // Getters and Setters
    public int getTransactionId() { return transactionId; }

    public BookModel getBook() { return book; }
    public void setBook(BookModel book) { this.book = book; }

    public CardModel getCard() { return card; }
    public void setCard(CardModel card) { this.card = card; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public double getFine() { return fine; }
    public void setFine(double fine) { this.fine = fine; }
}
