package persistence.entitites;

import business.dto.BookDTO;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NamedQueries({@NamedQuery(name="FindBookByTitle",query = "select book from Book book where book.title=:title"),
        @NamedQuery(name = "DeleteBookByVolumNumber",query = "delete Book where volumNumber=:volumNumber"),
   @NamedQuery(name = "UpdateBookByGender",query = "update Book set gender=:gender where title=:title")
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "volum_number")
    private int volumNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "borrowed")
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

    public Book(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook, Author author, Section section) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
        this.author = author;
        this.section = section;
    }

    public Book(String title, int volumNumber, String gender, boolean borrowed, boolean freeBook) {
        this.title = title;
        this.volumNumber = volumNumber;
        this.gender = gender;
        this.borrowed = borrowed;
        this.freeBook = freeBook;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

