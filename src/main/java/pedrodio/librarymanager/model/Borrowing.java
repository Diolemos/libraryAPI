package pedrodio.librarymanager.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Borrowing {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private   Borrower borrower;
 private   Book book;
 private   LocalDate borrowedDate;
 private   LocalDate returnDate;


    public Borrowing() {
    }

    public Borrowing(Borrower borrower, Book book, LocalDate borrowedDate, LocalDate returnDate) {
        this.borrower = borrower;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Borrower getBorrower() {
        return this.borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowedDate() {
        return this.borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
