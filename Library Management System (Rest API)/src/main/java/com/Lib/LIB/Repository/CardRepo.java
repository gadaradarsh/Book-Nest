package com.Lib.LIB.Repository;

import com.Lib.LIB.Model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<CardModel, Integer> {
    Optional<CardModel> findByStudent_StudentId(int studentId);
}
