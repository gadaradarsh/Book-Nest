package com.Lib.LIB.Controller;

import com.Lib.LIB.Model.BookModel;
import com.Lib.LIB.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String addBook(@RequestBody BookModel book) {
        bookService.addBook(book);
        return "Book added!";
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/genre/{genre}")
    public List<BookModel> getBooksByGenre(@PathVariable String genre) {
        return bookService.findByGenre(genre);
    }

    @GetMapping("/name/{bookName}")
    public List<BookModel> getBooksByName(@PathVariable String bookName) {
        return bookService.findByBookName(bookName);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody BookModel book) {
        bookService.updateBook(id, book);
        return "Book updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted!";
    }

    @DeleteMapping("/delete-all")
    public String deleteAllBooks() {
        bookService.deleteAll();
        return "All books deleted!";
    }
}