package com.Lib.LIB.Service;

import com.Lib.LIB.Model.BookModel;
import com.Lib.LIB.Model.CardModel;
import com.Lib.LIB.Model.TransactionModel;
import com.Lib.LIB.Repository.BookRepo;
import com.Lib.LIB.Repository.CardRepo;
import com.Lib.LIB.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionServiceIMPL implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private CardRepo cardRepository;

    @Override
    public String issueBook(int bookId, int cardId) {
        BookModel book = bookRepository.findById(bookId).orElse(null);
        CardModel card = cardRepository.findById(cardId).orElse(null);

        if (book == null || card == null) {
            return "Book or Card not found!";
        }

        if (book.getAvailable() <= 0) {
            return "Book is not available!";
        }

        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(14);

        TransactionModel transaction = new TransactionModel(book, card, issueDate, dueDate);

        transactionRepository.save(transaction);

        book.setAvailable(book.getAvailable() - 1);
        bookRepository.save(book);

        return "Book issued successfully.";
    }

    @Override
    public String returnBook(int transactionId) {
        TransactionModel transaction = transactionRepository.findById(transactionId).orElse(null);

        if (transaction == null) {
            return "Transaction not found!";
        }

        if (transaction.getReturnDate() != null) {
            return "Book already returned!";
        }

        LocalDate returnDate = LocalDate.now();
        transaction.setReturnDate(returnDate);

        long overdueDays = ChronoUnit.DAYS.between(transaction.getDueDate(), returnDate);
        double fine = (overdueDays > 0) ? overdueDays * 10.0 : 0.0;
        transaction.setFine(fine);

        BookModel book = transaction.getBook();
        book.setAvailable(book.getAvailable() + 1);
        bookRepository.save(book);

        transactionRepository.save(transaction);

        return "Book returned successfully. Fine: ₹" + fine;
    }

    @Override
    public List<TransactionModel> getTransactionsByStudent(int studentId) {
        return transactionRepository.findByCard_CardId(studentId);
    }

    @Override
    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
