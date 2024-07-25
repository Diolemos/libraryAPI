package pedrodio.librarymanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "book")
@Table(name = "book", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"title", "edition"})
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("title")
    @Column( )
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

    private Integer availableCopies;

    private Integer totalCopies;


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

    public Integer getTotalCopies(){
        return this.totalCopies;
    }
    public void setTotalCopies(Integer totalCopies){
        this.totalCopies =totalCopies;
    }

    public void setAvailableCopies(Integer availableCopies){
        this.availableCopies = availableCopies;
    }
    public Integer getAvailableCopies(){
        return this.availableCopies;
    }

    public String getInfo() {
        int edition = getEdition();
        String info = this.title + " , " + edition + getOrdinalSuffix(edition) + ", was published by " + getAuthor() + " in " + getReleaseYear() + ".";
        if (getTotalCopies() == 1) {
            info += "\n There is one copy of this book in the system. ";
        } 
        if(getTotalCopies()>1) {
            info += "\n There are "+ getTotalCopies() + " total number of copies in the system.";
        }
        info += "\n Available copies: "+ getAvailableCopies() + " .";
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
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
