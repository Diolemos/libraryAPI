package pedrodio.librarymanager.model;
import java.time.LocalDate;

public class Borrowing {
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
