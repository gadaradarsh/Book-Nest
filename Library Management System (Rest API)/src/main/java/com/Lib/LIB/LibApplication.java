package com.Lib.LIB;

import com.Lib.LIB.Model.*;
import com.Lib.LIB.Service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LibApplication.class, args);
	}
//}
// package com.Lib.LIB;
//
//import com.Lib.LIB.Model.*;
//import com.Lib.LIB.Service.*;
//import com.Lib.LIB.Repository.*;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootApplication
//public class LibApplication {
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(LibApplication.class, args);
//
//		// Initialize Services
//		AuthorServiceIMPL authorService = context.getBean(AuthorServiceIMPL.class);
//		BookServiceIMPL bookService = context.getBean(BookServiceIMPL.class);
//		StudentServiceIMPL studentService = context.getBean(StudentServiceIMPL.class);
//		CardServiceIMPL cardService = context.getBean(CardServiceIMPL.class);
//		TransactionServiceIMPL transactionService = context.getBean(TransactionServiceIMPL.class);
//
//		// Repositories for direct access when needed
//		AuthorRepo authorRepo = context.getBean(AuthorRepo.class);
//		BookRepo bookRepo = context.getBean(BookRepo.class);
//		StudentRepo studentRepo = context.getBean(StudentRepo.class);
//		CardRepo cardRepo = context.getBean(CardRepo.class);
//		TransactionRepo transactionRepo = context.getBean(TransactionRepo.class);
//
//		try {
//			System.out.println("\n===== COMPREHENSIVE LIBRARY MANAGEMENT SYSTEM TESTING =====\n");
//
//			// Clean existing data for fresh testing
//			System.out.println("Cleaning up existing data...");
//			try {
//				//transactionService.deleteAll();
//				cardService.deleteAll();
//				studentService.deleteAll();
//				bookService.deleteAll();
//				authorService.deleteAll();
//				System.out.println("Data cleanup complete.");
//			} catch (Exception e) {
//				System.out.println("Warning: Could not clean up all data. Continuing with tests...");
//				e.printStackTrace();
//			}
//
//			// ===== AUTHOR TESTS =====
//			System.out.println("\n===== TESTING AUTHOR OPERATIONS =====");
//
//			// 1. Create multiple authors
//			AuthorModel author1 = new AuthorModel();
//			author1.setAuthorName("J.K. Rowling");
//			author1.setCountry("UK");
//			author1.setEmail("jkrowling@example.com");
//			author1.setAge(55);
//			authorService.addAuthor(author1);
//			System.out.println("Author 1 created: " + author1);
//
//			AuthorModel author2 = new AuthorModel();
//			author2.setAuthorName("George R.R. Martin");
//			author2.setCountry("USA");
//			author2.setEmail("grrm@example.com");
//			author2.setAge(72);
//			authorService.addAuthor(author2);
//			System.out.println("Author 2 created: " + author2);
//
//			AuthorModel author3 = new AuthorModel();
//			author3.setAuthorName("Agatha Christie");
//			author3.setCountry("UK");
//			author3.setEmail("agatha@example.com");
//			author3.setAge(85);
//			authorService.addAuthor(author3);
//			System.out.println("Author 3 created: " + author3);
//
//			// 2. Retrieve authors
//			List<AuthorModel> allAuthors = authorService.getAllAuthors();
//			System.out.println("Total authors found: " + allAuthors.size());
//
//			// 3. Find author by ID
//			AuthorModel retrievedAuthor = authorService.findAuthorById(author1.getAuthorId());
//			System.out.println("Retrieved author by ID: " + retrievedAuthor.getAuthorName());
//
//			// 4. Find authors by country
//			List<AuthorModel> ukAuthors = authorService.findByCountry("UK");
//			System.out.println("UK authors found: " + ukAuthors.size());
//
//			// 5. Update an author
//			author2.setAge(73);
//			authorService.updateAuthor(author2.getAuthorId(), author2);
//			AuthorModel updatedAuthor = authorService.findAuthorById(author2.getAuthorId());
//			System.out.println("Updated author age: " + updatedAuthor.getAge());
//
//			// ===== BOOK TESTS =====
//			System.out.println("\n===== TESTING BOOK OPERATIONS =====");
//
//			// 1. Create books for each author
//			BookModel book1 = new BookModel();
//			book1.setBookName("Harry Potter and the Philosopher's Stone");
//			book1.setGenre("Fantasy");
//			book1.setAvailable(10);
//			book1.setAuthor(author1);
//			bookService.addBook(book1);
//			System.out.println("Book 1 created: " + book1.getBookName() + " by " + book1.getAuthor().getAuthorName());
//
//			BookModel book2 = new BookModel();
//			book2.setBookName("Harry Potter and the Chamber of Secrets");
//			book2.setGenre("Fantasy");
//			book2.setAvailable(8);
//			book2.setAuthor(author1);
//			bookService.addBook(book2);
//			System.out.println("Book 2 created: " + book2.getBookName());
//
//			BookModel book3 = new BookModel();
//			book3.setBookName("A Game of Thrones");
//			book3.setGenre("Fantasy");
//			book3.setAvailable(5);
//			book3.setAuthor(author2);
//			bookService.addBook(book3);
//			System.out.println("Book 3 created: " + book3.getBookName());
//
//			BookModel book4 = new BookModel();
//			book4.setBookName("Murder on the Orient Express");
//			book4.setGenre("Mystery");
//			book4.setAvailable(7);
//			book4.setAuthor(author3);
//			bookService.addBook(book4);
//			System.out.println("Book 4 created: " + book4.getBookName());
//
//			// 2. Retrieve all books
//			List<BookModel> allBooks = bookService.getAllBooks();
//			System.out.println("Total books found: " + allBooks.size());
//
//			// 3. Find books by genre
//			List<BookModel> fantasyBooks = bookService.findByGenre("Fantasy");
//			System.out.println("Fantasy books found: " + fantasyBooks.size());
//
//			List<BookModel> mysteryBooks = bookService.findByGenre("Mystery");
//			System.out.println("Mystery books found: " + mysteryBooks.size());
//
//			// 4. Find books by name
//			List<BookModel> harryPotterBooks = bookService.findByBookName("Harry Potter");
//			System.out.println("Harry Potter books found: " + harryPotterBooks.size());
//
//			// 5. Update a book
//			book4.setAvailable(10);
//			bookService.updateBook(book4.getBookId(), book4);
//			BookModel updatedBook = bookService.findBookById(book4.getBookId());
//			System.out.println("Updated book availability: " + updatedBook.getAvailable());
//
//			// ===== STUDENT AND CARD TESTS =====
//			System.out.println("\n===== TESTING STUDENT & CARD OPERATIONS =====");
//
//			// 1. Create students with different roles
//			StudentModel student1 = new StudentModel();
//			student1.setName("Harry Potter");
//			student1.setAge(18);
//			student1.setEmailId("harry@hogwarts.edu");
//			student1.setUsername("harrypotter");
//			student1.setPassword("gryffindor123");
//			student1.setRole("STUDENT");
//			studentService.addStudent(student1);
//			System.out.println("Student 1 created: " + student1.getName());
//
//			StudentModel student2 = new StudentModel();
//			student2.setName("Hermione Granger");
//			student2.setAge(18);
//			student2.setEmailId("hermione@hogwarts.edu");
//			student2.setUsername("hermione");
//			student2.setPassword("leviosa");
//			student2.setRole("STUDENT");
//			studentService.addStudent(student2);
//			System.out.println("Student 2 created: " + student2.getName());
//
//			StudentModel admin = new StudentModel();
//			admin.setName("Albus Dumbledore");
//			admin.setAge(150);
//			admin.setEmailId("dumbledore@hogwarts.edu");
//			admin.setUsername("admin");
//			admin.setPassword("lemondrops");
//			admin.setRole("ADMIN");
//			studentService.addStudent(admin);
//			System.out.println("Admin created: " + admin.getName());
//
//			// 2. Create cards for each student
//			CardModel card1 = new CardModel();
//			card1.setCardStatus(true);
//			card1.setStudent(student1);
//			cardService.addCard(card1);
//			System.out.println("Card created for student 1: " + card1.getCardId());
//
//			CardModel card2 = new CardModel();
//			card2.setCardStatus(true);
//			card2.setStudent(student2);
//			cardService.addCard(card2);
//			System.out.println("Card created for student 2: " + card2.getCardId());
//
//			CardModel adminCard = new CardModel();
//			adminCard.setCardStatus(true);
//			adminCard.setStudent(admin);
//			cardService.addCard(adminCard);
//			System.out.println("Card created for admin: " + adminCard.getCardId());
//
//			// 3. Update students with card references
//			student1.setCard(card1);
//			studentService.updateStudent(student1.getStudentId(), student1);
//
//			student2.setCard(card2);
//			studentService.updateStudent(student2.getStudentId(), student2);
//
//			admin.setCard(adminCard);
//			studentService.updateStudent(admin.getStudentId(), admin);
//			System.out.println("All students updated with their respective cards");
//
//			// 4. Retrieve all students and cards
//			List<StudentModel> allStudents = studentService.getAllStudents();
//			System.out.println("Total students found: " + allStudents.size());
//
//			List<CardModel> allCards = cardService.getAllCards();
//			System.out.println("Total cards found: " + allCards.size());
//
//			// 5. Find students by name
//			List<StudentModel> harryStudents = studentService.getStudentsByName("Harry");
//			System.out.println("Students named Harry: " + harryStudents.size());
//
//			// ===== TRANSACTION TESTS =====
//			System.out.println("\n===== TESTING TRANSACTION OPERATIONS =====");
//
//			// 1. Issue books to students
//			System.out.println("1. Testing book issue operations...");
//			String issueResult1 = transactionService.issueBook(book1.getBookId(), card1.getCardId());
//			System.out.println("Issue result for student 1, book 1: " + issueResult1);
//
//			String issueResult2 = transactionService.issueBook(book3.getBookId(), card1.getCardId());
//			System.out.println("Issue result for student 1, book 3: " + issueResult2);
//
//			String issueResult3 = transactionService.issueBook(book2.getBookId(), card2.getCardId());
//			System.out.println("Issue result for student 2, book 2: " + issueResult3);
//
//			String issueResult4 = transactionService.issueBook(book4.getBookId(), card2.getCardId());
//			System.out.println("Issue result for student 2, book 4: " + issueResult4);
//
//			// 2. Check book availability after issuing
//			BookModel book1AfterIssue = bookService.findBookById(book1.getBookId());
//			System.out.println("Book 1 availability after issue: " + book1AfterIssue.getAvailable());
//
//			BookModel book3AfterIssue = bookService.findBookById(book3.getBookId());
//			System.out.println("Book 3 availability after issue: " + book3AfterIssue.getAvailable());
//
//			// 3. Retrieve transactions
//			List<TransactionModel> allTransactions = transactionService.getAllTransactions();
//			System.out.println("Total transactions found: " + allTransactions.size());
//
//			List<TransactionModel> student1Transactions = transactionService.getTransactionsByStudent(student1.getStudentId());
//			System.out.println("Transactions for student 1: " + student1Transactions.size());
//
//			// 4. Return books
//			System.out.println("2. Testing book return operations...");
//			if (!student1Transactions.isEmpty()) {
//				String returnResult1 = transactionService.returnBook(student1Transactions.get(0).getTransactionId());
//				System.out.println("Return result for first transaction of student 1: " + returnResult1);
//			}
//
//			List<TransactionModel> student2Transactions = transactionService.getTransactionsByStudent(student2.getStudentId());
//			if (!student2Transactions.isEmpty()) {
//				String returnResult2 = transactionService.returnBook(student2Transactions.get(0).getTransactionId());
//				System.out.println("Return result for first transaction of student 2: " + returnResult2);
//			}
//
//			// 5. Check book availability after returns
//			BookModel book1AfterReturn = bookService.findBookById(book1.getBookId());
//			System.out.println("Book 1 availability after return: " + book1AfterReturn.getAvailable());
//
//			BookModel book2AfterReturn = bookService.findBookById(book2.getBookId());
//			System.out.println("Book 2 availability after return: " + book2AfterReturn.getAvailable());
//
//			// 6. Test invalid operations
//			System.out.println("3. Testing invalid operations...");
//			// Try to issue a book with invalid book ID
//			String invalidBookResult = transactionService.issueBook(999, card1.getCardId());
//			System.out.println("Result of issuing with invalid book ID: " + invalidBookResult);
//
//			// Try to issue a book with invalid card ID
//			String invalidCardResult = transactionService.issueBook(book1.getBookId(), 999);
//			System.out.println("Result of issuing with invalid card ID: " + invalidCardResult);
//
//			// Try to return a book with invalid transaction ID
//			String invalidReturnResult = transactionService.returnBook(999);
//			System.out.println("Result of returning with invalid transaction ID: " + invalidReturnResult);
//
//			// ===== EDGE CASE TESTS =====
//			System.out.println("\n===== TESTING EDGE CASES =====");
//
//			// 1. Test trying to issue a book with 0 availability
//			BookModel unavailableBook = new BookModel();
//			unavailableBook.setBookName("Out of Stock Book");
//			unavailableBook.setGenre("Test");
//			unavailableBook.setAvailable(0);
//			unavailableBook.setAuthor(author1);
//			bookService.addBook(unavailableBook);
//			System.out.println("Created unavailable book with ID: " + unavailableBook.getBookId());
//
//			String unavailableBookResult = transactionService.issueBook(unavailableBook.getBookId(), card1.getCardId());
//			System.out.println("Result of issuing unavailable book: " + unavailableBookResult);
//
//			// 2. Test update operations
//			System.out.println("Testing update operations...");
//			student1.setAge(19);
//			studentService.updateStudent(student1.getStudentId(), student1);
//			StudentModel updatedStudent = studentService.getStudentById(student1.getStudentId());
//			System.out.println("Updated student age: " + updatedStudent.getAge());
//
//			// 3. Test deletion operations
//			System.out.println("Testing deletion operations...");
//			StudentModel tempStudent = new StudentModel();
//			tempStudent.setName("Temporary Student");
//			tempStudent.setAge(25);
//			tempStudent.setEmailId("temp@example.com");
//			tempStudent.setUsername("tempuser");
//			tempStudent.setPassword("temppass");
//			tempStudent.setRole("STUDENT");
//			studentService.addStudent(tempStudent);
//			System.out.println("Created temporary student with ID: " + tempStudent.getStudentId());
//
//			studentService.deleteStudent(tempStudent.getStudentId());
//			StudentModel deletedStudent = studentService.getStudentById(tempStudent.getStudentId());
//			System.out.println("After deletion, student exists: " + (deletedStudent != null));
//
//			System.out.println("\n===== ALL TESTS COMPLETED SUCCESSFULLY =====");
//
//			// Final statistics
//			System.out.println("\n===== FINAL SYSTEM STATISTICS =====");
//			System.out.println("Total Authors: " + authorService.getAllAuthors().size());
//			System.out.println("Total Books: " + bookService.getAllBooks().size());
//			System.out.println("Total Students: " + studentService.getAllStudents().size());
//			System.out.println("Total Cards: " + cardService.getAllCards().size());
//			System.out.println("Total Transactions: " + transactionService.getAllTransactions().size());
//
//		} catch (Exception e) {
//			System.err.println("\n===== TEST FAILED =====");
//			System.err.println("Exception: " + e.getMessage());
//			e.printStackTrace();
//		}
//	}
}