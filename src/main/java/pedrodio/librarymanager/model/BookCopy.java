package pedrodio.librarymanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("serialNumber")
    @Column
    private String serialNumber;
    @JsonProperty("isBorrowed")
    @Column
    private Boolean isBorrowed;
    @JsonProperty("condition")
    @Column
    private String condition;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean isIsBorrowed() {
        return this.isBorrowed;
    }

    public Boolean getIsBorrowed() {
        return this.isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        if (Constants.STATUS.contains(condition)) {
            this.condition = condition;
        } else {
            throw new IllegalArgumentException("Invalid condition value: " + condition);
        }
    }


    public void setBook(Book book){
        this.book = book;
    }
    public Book getBook(){
        return this.book;
    }

}
