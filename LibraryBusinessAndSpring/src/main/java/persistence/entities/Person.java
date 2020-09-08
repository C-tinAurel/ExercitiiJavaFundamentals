package persistence.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({@NamedQuery(name="FindPersonByName",query = "select person from Person person where person.name=:name"),
@NamedQuery(name = "DeletePersonByYearOfBirth",query = "delete Person where person.yearOfBirth=:yearOfBirth")})
@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name="year_of_birth")
    private int yearOfBirth;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="persons_books",joinColumns = {@JoinColumn(name = "persons_id")},inverseJoinColumns ={@JoinColumn(name="books_id")} )
    private Set<Book> books;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="persons_sections",joinColumns = {@JoinColumn(name="persons_id")},inverseJoinColumns = {@JoinColumn(name="sections_id")})
    private Set<Section> sections;

    public Person() {
    }

    public Person(String name, String surname, String address, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String name, String surname, String address, int yearOfBirth, Set<Book> books, Set<Section> sections) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.books = books;
        this.sections = sections;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", books=" + books +
                ", sections=" + sections +
                '}';
    }
}
