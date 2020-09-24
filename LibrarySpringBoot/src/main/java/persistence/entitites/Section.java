package persistence.entitites;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "sections")
@NamedQueries({@NamedQuery(name = "SelectSectionByName", query = "select section from Section section where section.name=:name"),
        @NamedQuery(name = "DeleteSectionByName", query = "delete Section where name=:name"),
        @NamedQuery(name = "UpdateSection", query = "update Section set authorSet=:authorSet where name=:name ")})
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "sections_authors", joinColumns = {@JoinColumn(name = "sections_id")}, inverseJoinColumns = {@JoinColumn(name = "authors_id")})
    private Set<Author> authorSet;
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Section() {

    }

    public Section(String name, Set<Book> books) {
        this.name = name;
        this.books = books;

    }

    public Section(String name) {
        this.name = name;
    }

   /* public Section(String name, Set<Author> authorSet) {
        this.name = name;
        this.authorSet = authorSet;
    }*/


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

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", authorSet=" + authorSet +
                '}';
    }
}
