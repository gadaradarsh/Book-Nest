package com.Lib.LIB.Repository;

import com.Lib.LIB.Model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionModel, Integer> {
    List<TransactionModel> findByBook_BookId(int bookId);
    List<TransactionModel> findByCard_CardId(int cardId);
}
