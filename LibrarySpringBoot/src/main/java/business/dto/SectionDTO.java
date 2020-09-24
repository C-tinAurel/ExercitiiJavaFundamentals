package business.dto;

import java.util.Set;

public class SectionDTO {
    private int id;
    private String name;
    private Set<AuthorDTO> authorDTOSet;
    private Set<BookDTO> bookDTOSet;

    public SectionDTO() {
    }

    public SectionDTO(String name) {
        this.name = name;
    }

    public SectionDTO(String name, Set<AuthorDTO> authorDTOSet, Set<BookDTO> bookDTOSet) {
        this.name = name;
        this.authorDTOSet = authorDTOSet;
        this.bookDTOSet = bookDTOSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorDTO> getAuthorDTOSet() {
        return authorDTOSet;
    }

    public void setAuthorDTOSet(Set<AuthorDTO> authorDTOSet) {
        this.authorDTOSet = authorDTOSet;
    }

    public Set<BookDTO> getBookDTOSet() {
        return bookDTOSet;
    }

    public void setBookDTOSet(Set<BookDTO> bookDTOSet) {
        this.bookDTOSet = bookDTOSet;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
