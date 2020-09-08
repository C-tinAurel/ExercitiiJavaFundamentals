package persistence.entities;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({@NamedQuery(name="FindSectionByName",query = "select section from Section section where section.name=:name"),
        @NamedQuery(name="DeleteSectionByName",query = "delete Section where section.name=:name")})
@Entity
@Table(name="sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL)
    private Set<Book> book;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="sections_authors",joinColumns = {@JoinColumn(name="sections_id")},inverseJoinColumns = {@JoinColumn(name="authors_id")})
    private Set<Author> authors;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public Section(String name, Set<Book> book, Set<Author> authors) {
        this.name = name;
        this.book = book;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", book=" + book +
                ", authors=" + authors +
                '}';
    }
}
