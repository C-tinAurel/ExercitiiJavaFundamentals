package persistence.entities;

import javax.persistence.*;
import java.security.Provider;
@NamedQueries({@NamedQuery(name = "FindTitleBook",query = "select book from Book book where book.title=:title"),@NamedQuery(name = "DeleteByVolumNumber",query = "delete Book where book.volumNumber=:volumNumber")})
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="volum_number")
    private int volumNumber;
    @Column(name="gender")
    private String gender;
    @Column(name="borrowed")
    private boolean borrowed;
    @Column(name="free_book")
    private boolean freeBook;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authors_id")
    private Author author;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sections_id")
    private Section section;

    public Book() {
    }

    public Book(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
    }

    public Book(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook, Author author, Section section) {
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
        return "Book{" +
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
