package com.Lib.LIB.Controller;

import com.Lib.LIB.Model.TransactionModel;
import com.Lib.LIB.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issue")
    public String issueBook(@RequestParam int bookId, @RequestParam int cardId) {
        return transactionService.issueBook(bookId, cardId);
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam int transactionId) {
        return transactionService.returnBook(transactionId);
    }

    @GetMapping("/student/{studentId}")
    public List<TransactionModel> getTransactionsByStudent(@PathVariable int studentId) {
        return transactionService.getTransactionsByStudent(studentId);
    }

    @GetMapping
    public List<TransactionModel> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
