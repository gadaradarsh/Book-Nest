package com.Lib.LIB.Service;

import com.Lib.LIB.Model.BookModel;
import com.Lib.LIB.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookRepo bookRepository;

    @Override
    public void addBook(BookModel book) {
        bookRepository.save(book);
    }

    @Override
    public BookModel findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookModel> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<BookModel> findByBookName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(int id, BookModel updatedBook) {
        if (bookRepository.existsById(id)) {
            updatedBook.setBookId(id);
            bookRepository.save(updatedBook);
        }
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {   // Fixed method name
        bookRepository.deleteAll();
    }
}
