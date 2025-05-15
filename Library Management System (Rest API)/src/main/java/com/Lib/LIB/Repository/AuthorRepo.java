package com.Lib.LIB.Repository;

import com.Lib.LIB.Model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorModel, Integer> {
    Optional<AuthorModel> findByAuthorName(String authorName);
    List<AuthorModel> findByCountry(String country);
}
