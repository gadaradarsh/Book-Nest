package com.Lib.LIB.Service;

import com.Lib.LIB.Model.BookModel;
import java.util.List;

public interface BookService {
    void addBook(BookModel book);
    BookModel findBookById(int id);
    List<BookModel> findByGenre(String genre);
    List<BookModel> findByBookName(String bookName);
    List<BookModel> getAllBooks();
    void updateBook(int id, BookModel updatedBook);
    void deleteBook(int id);
    void deleteAll();  // Fixed method name
}
