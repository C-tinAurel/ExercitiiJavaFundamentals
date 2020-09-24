
package persistence.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
@NamedQueries({@NamedQuery(name="findAuthorByName", query = "select author from Author author where author.name=:name"),
        @NamedQuery(name="DeleteAuthorByName",query = "delete Author where name=:name"),
        @NamedQuery(name = "UpdateSurnameAuthor",query = "update Author  set surname=:surname where name=:name")
})
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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "authors_persons", joinColumns = {@JoinColumn(name = "authors_id")}, inverseJoinColumns = {@JoinColumn(name = "persons_id")})
    private Set<Person> personSet;

    public Author() {

    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public Author(String name, String surname, Book book, Set<Person> personSet) {
        this.name = name;
        this.surname = surname;
        this.book = book;
        this.personSet = personSet;

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

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", book=" + book +
                ", personSet=" + personSet +
                '}';
    }
}
