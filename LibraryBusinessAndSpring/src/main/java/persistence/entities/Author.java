package persistence.entities;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({@NamedQuery(name="SelectAuthorByName",query = "select author from Author author where author.name=:name"),
@NamedQuery(name="DeleteAuthorBySurname",query = "delete Author where surname=:surname")})
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private Book book;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="authors_persons",joinColumns = {@JoinColumn(name="authors_id")},inverseJoinColumns = {@JoinColumn(name = "persons_id")})
    private Set<Person> persons;

    public Author() {
    }

    public Author(String name, String surname, Book book) {
        this.name = name;
        this.surname = surname;
        this.book = book;
    }

    public Author(String name, String surname, Book book, Set<Person> persons) {
        this.name = name;
        this.surname = surname;
        this.book = book;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Book getBook(Book book) {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
