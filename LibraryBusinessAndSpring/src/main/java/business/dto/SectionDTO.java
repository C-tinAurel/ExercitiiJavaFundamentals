package business.dto;

import persistence.entities.Author;
import persistence.entities.Book;

import java.util.Set;

public class SectionDTO {
    private int id;
    private String name;
    private Set<BookDTO> bookDTOSet;
    private Set<AuthorDTO> authorDTOS;

    public SectionDTO() {
    }

    public SectionDTO(String name) {
        this.name = name;
    }

    public SectionDTO(String name, Set<BookDTO> bookDTOSet, Set<AuthorDTO> authorDTOS) {
        this.name = name;
        this.bookDTOSet = bookDTOSet;
        this.authorDTOS = authorDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookDTO> getBookDTOSet() {
        return bookDTOSet;
    }

    public void setBookDTOSet(Set<BookDTO> bookDTOSet) {
        this.bookDTOSet = bookDTOSet;
    }

    public Set<AuthorDTO> getAuthorDTOS() {
        return authorDTOS;
    }

    public void setAuthorDTOS(Set<AuthorDTO> authorDTOS) {
        this.authorDTOS = authorDTOS;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
