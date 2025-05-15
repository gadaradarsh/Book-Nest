package com.Lib.LIB.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookName;
    private String genre;
    private int available;

    @ManyToOne
    @JoinColumn(name = "author_id" ,referencedColumnName = "authorId")
    private AuthorModel author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CardModel> cards;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<TransactionModel> transactions;

    public BookModel() {}

    public BookModel(String bookName, String genre, int available, AuthorModel author) {
        this.bookName = bookName;
        this.genre = genre;
        this.available = Math.max(available, 0);
        this.author = author;
    }

    // Getters and Setters

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = Math.max(available, 0); }

    public AuthorModel getAuthor() { return author; }
    public void setAuthor(AuthorModel author) { this.author = author; }

    public List<TransactionModel> getTransactions() { return transactions; }
    public void setTransactions(List<TransactionModel> transactions) { this.transactions = transactions; }

    @Override
    public String toString() {
        return "BookModel{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                ", author=" + author +
                '}';
    }
}
