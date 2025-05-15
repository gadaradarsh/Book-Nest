package com.Lib.LIB.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String department;
    private boolean cardStatus;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private StudentModel student;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private BookModel book;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TransactionModel> transactions;

    public CardModel() {}

    public CardModel(String department, boolean cardStatus) {
        this.department = department;
        this.cardStatus = cardStatus;
    }

    // Getters and Setters
    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }


    public int getCardId() { return cardId; }
    public void setCardId(int cardId) { this.cardId = cardId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public boolean isCardStatus() { return cardStatus; }
    public void setCardStatus(boolean cardStatus) { this.cardStatus = cardStatus; }

    public StudentModel getStudent() { return student; }
    public void setStudent(StudentModel student) { this.student = student; }

    public List<TransactionModel> getTransactions() { return transactions; }
    public void setTransactions(List<TransactionModel> transactions) { this.transactions = transactions; }
}
