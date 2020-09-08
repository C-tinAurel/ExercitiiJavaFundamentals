package business.dto;

import persistence.entities.Book;
import persistence.entities.Section;

import java.util.Set;

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int yearOfBirth;
    private Set<Book> books;
    private Set<Section> sections;

    public PersonDTO() {
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth, Set<Book> books, Set<Section> sections) {
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
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", books=" + books +
                ", sections=" + sections +
                '}';
    }
}
