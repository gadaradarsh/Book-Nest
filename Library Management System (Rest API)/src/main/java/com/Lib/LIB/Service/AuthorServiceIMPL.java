package com.Lib.LIB.Service;

import com.Lib.LIB.Model.AuthorModel;
import com.Lib.LIB.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepo authorRepository;

    @Override
    public void addAuthor(AuthorModel author) {
        authorRepository.save(author);
    }

    @Override
    public AuthorModel findAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<AuthorModel> findByName(String authorName) {
        return authorRepository.findByAuthorName(authorName);
    }

    @Override
    public List<AuthorModel> findByCountry(String country) {
        return authorRepository.findByCountry(country);
    }

    @Override
    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void updateAuthor(int id, AuthorModel updatedAuthor) {
        if (authorRepository.existsById(id)) {
            updatedAuthor.setAuthorId(id);
            authorRepository.save(updatedAuthor);
        }
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {   // Fixed method name
        authorRepository.deleteAll();
    }
}
