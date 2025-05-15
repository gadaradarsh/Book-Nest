package com.Lib.LIB.Repository;

import com.Lib.LIB.Model.BookModel;
import com.Lib.LIB.Model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookModel, Integer> {
    List<BookModel> findByGenre(String genre);
    List<BookModel> findByBookName(String bookName);
    List<BookModel> findByAuthor(AuthorModel author);
}
