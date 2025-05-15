package com.Lib.LIB.Service;

import com.Lib.LIB.Model.AuthorModel;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void addAuthor(AuthorModel author);
    AuthorModel findAuthorById(int id);
    Optional<AuthorModel> findByName(String authorName);
    List<AuthorModel> findByCountry(String country);
    List<AuthorModel> getAllAuthors();
    void updateAuthor(int id, AuthorModel updatedAuthor);
    void deleteAuthor(int id);
    void deleteAll();
}
