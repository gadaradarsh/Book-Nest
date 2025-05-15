package com.Lib.LIB.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Author")
public class AuthorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;
    private String country;
    private String email;
    private int age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BookModel> books;

    public AuthorModel() {
    }

    public AuthorModel(int authorId, String authorName, String country, String email, int age) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.country = country;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
