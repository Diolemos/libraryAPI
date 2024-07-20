package pedrodio.librarymanager.model;


public class Book {
   private String title;
   private String author;
   private Integer releaseYear;
   private Integer edition;
   private Boolean isBorrowed = false;


    public Book() {
    }
    

    public Book(String title, String author, Integer releaseYear, Integer edition) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.edition = edition;
        
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
        this.edition = edition;
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

    public String getInfo(){
        int edition = getEdition();
        String info = this.title +" , "+edition+getOrdinalSuffix(edition) + ", was published by " + getAuthor() + " in " + getReleaseYear() + "." ;
        if(getIsBorrowed()){
            info = info + "\nThe book is borrowed";
        }else{
            info  += "\n The book is not borrowed";
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
    return "Book{" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", releaseYear=" + releaseYear +
            ", edition=" + edition + getOrdinalSuffix(edition) +
            ", isBorrowed=" + isBorrowed +
            '}';
}

}
