package business.dto;

import persistence.entities.Book;
import persistence.entities.Person;

import java.util.Set;

public class AuthorDTO {

    private int id;
    private String name;
    private String surname;
    private BookDTO bookDTO;
    private Set<PersonDTO> personsDTO;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorDTO(String name, String surname, BookDTO bookDTO, Set<PersonDTO> personsDTO) {
        this.name = name;
        this.surname = surname;
        this.bookDTO = bookDTO;
        this.personsDTO = personsDTO;
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

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public Set<PersonDTO> getPersonsDTO() {
        return personsDTO;
    }

    public void setPersonsDTO(Set<PersonDTO> personsDTO) {
        this.personsDTO = personsDTO;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
