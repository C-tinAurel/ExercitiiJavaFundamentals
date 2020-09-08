package business.dto;

import persistence.entities.Author;
import persistence.entities.Book;

import java.util.Set;

public class SectionDTO {
    private int id;
    private String name;
    private Set<Book> books;
    private Set<Author> authors;

    public SectionDTO() {
    }

    public SectionDTO(String name) {
        this.name = name;
    }

    public SectionDTO(String name, Set<Book> books, Set<Author> authors) {
        this.name = name;
        this.books = books;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "name='" + name + '\'' +
                ", books=" + books +
                ", authors=" + authors +
                '}';
    }
}
