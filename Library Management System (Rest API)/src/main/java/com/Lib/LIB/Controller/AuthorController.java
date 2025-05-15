package com.Lib.LIB.Controller;

import com.Lib.LIB.Model.AuthorModel;
import com.Lib.LIB.Service.AuthorService;
import com.Lib.LIB.Model.BookModel;
import com.Lib.LIB.Service.BookService;
import com.Lib.LIB.Model.CardModel;
import com.Lib.LIB.Service.CardService;
import com.Lib.LIB.Model.StudentModel;
import com.Lib.LIB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public String addAuthor(@RequestBody AuthorModel author) {
        authorService.addAuthor(author);
        return "Author added!";
    }

    @GetMapping("/{id}")
    public AuthorModel getAuthorById(@PathVariable int id) {
        return authorService.findAuthorById(id);
    }

    @GetMapping
    public List<AuthorModel> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/name/{authorName}")
    public Optional<AuthorModel> getAuthorByName(@PathVariable String authorName) {
        return authorService.findByName(authorName);
    }

    @GetMapping("/country/{country}")
    public List<AuthorModel> getAuthorsByCountry(@PathVariable String country) {
        return authorService.findByCountry(country);
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable int id, @RequestBody AuthorModel author) {
        authorService.updateAuthor(id, author);
        return "Author updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return "Author deleted!";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllAuthors() {
        authorService.deleteAll();
        return "All authors deleted!";
    }
}