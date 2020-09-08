package business.dto;

import persistence.entities.Author;
import persistence.entities.Section;

public class BookDTO {
    private int id;
    private String title;
    private int volumNumber;
    private String gender;
    private boolean borrowed;
    private boolean freeBook;
    private Author author;
    private Section section;

    public BookDTO() {
    }

    public BookDTO(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
    }

    public BookDTO(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook, Author author, Section section) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
        this.author = author;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolumNumber() {
        return volumNumber;
    }

    public void setVolumNumber(int volumNumber) {
        this.volumNumber = volumNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean isFreeBook() {
        return freeBook;
    }

    public void setFreeBook(boolean freeBook) {
        this.freeBook = freeBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", volumNumber=" + volumNumber +
                ", gender='" + gender + '\'' +
                ", borrowed=" + borrowed +
                ", freeBook=" + freeBook +
                ", author=" + author +
                ", section=" + section +
                '}';
    }
}
