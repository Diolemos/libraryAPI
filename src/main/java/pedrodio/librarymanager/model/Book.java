package pedrodio.librarymanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("title")
    @Column()
    private String title;

    @JsonProperty("author")
    @Column()
    private String author;

    @JsonProperty("releaseYear")
    @Column()
    private Integer releaseYear;

    @JsonProperty("edition")
    @Column()
    private Integer edition = 1;  // Default value for edition

    @JsonProperty("isBorrowed")
    @Column()
    private Boolean isBorrowed = false;



    public Book() {
    }


    // Getters and setters...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getEdition() {
        return this.edition;
    }

    public void setEdition(Integer edition) {
        if (edition == null) {
            this.edition = 1;  // Default value if edition is null
        } else {
            this.edition = edition;
        }
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

    public String getInfo() {
        int edition = getEdition();
        String info = this.title + " , " + edition + getOrdinalSuffix(edition) + ", was published by " + getAuthor() + " in " + getReleaseYear() + ".";
        if (getIsBorrowed()) {
            info = info + "\nThe book is borrowed";
        } else {
            info += "\nThe book is not borrowed";
        }
        return info;
    }

    private String getOrdinalSuffix(int value) {
        if (value >= 11 && value <= 13) {
            return "th";
        }
        switch (value % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    @Override
    public String toString() {
        Integer edition = getEdition();
        String editionInfo = (edition == null) ? "unknown edition" : edition + getOrdinalSuffix(edition);
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", edition=" + editionInfo +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
