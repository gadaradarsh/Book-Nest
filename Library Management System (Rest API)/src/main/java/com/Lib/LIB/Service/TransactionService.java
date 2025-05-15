package com.Lib.LIB.Service;

import com.Lib.LIB.Model.TransactionModel;
import java.util.List;

public interface TransactionService {
    String issueBook(int bookId, int cardId);
    String returnBook(int transactionId);
    List<TransactionModel> getTransactionsByStudent(int studentId);
    List<TransactionModel> getAllTransactions();  // New method
}
