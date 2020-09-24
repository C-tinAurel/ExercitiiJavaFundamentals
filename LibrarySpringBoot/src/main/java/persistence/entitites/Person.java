package persistence.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "persons")
@NamedQueries({@NamedQuery(name = "SelectPersonByName", query = "select person from Person person where person.name=:name"),
        @NamedQuery(name = "DeletePersonByYearOfBirth", query = "delete Person where yearOfBirth=:yearOfBirth"),
        @NamedQuery(name = "UpdatePersonByAddress", query = "update Person set address=:address where name=:name")})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "persons_books", joinColumns = {@JoinColumn(name = "persons_id")}, inverseJoinColumns = {@JoinColumn(name = "books_id")})
    private Set<Book> bookSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "persons_sections", joinColumns = {@JoinColumn(name = "persons_id")}, inverseJoinColumns = {@JoinColumn(name = "sections_id")})
    private Set<Section> sectionSet;

    public Person() {

    }

    public Person(String name, String surname, String address, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String name, String surname, String address, int yearOfBirth, Set<Book> bookSet, Set<Section> sectionSet) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.bookSet = bookSet;
        this.sectionSet = sectionSet;
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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Set<Section> getSectionSet() {
        return sectionSet;
    }

    public void setSectionSet(Set<Section> sectionSet) {
        this.sectionSet = sectionSet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
