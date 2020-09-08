package business.dto;

import persistence.entities.Book;
import persistence.entities.Person;

import java.util.Set;

public class AuthorDTO {

    private int id;
    private String name;
    private String surname;
    private Book book;
    private Set<Person> persons;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorDTO(String name, String surname, Book book, Set<Person> persons) {
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

    public Book getBook() {
        return book;
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
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
