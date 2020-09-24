package business.dto;

import persistence.entitites.Book;
import persistence.entitites.Person;

import java.util.Set;

public class AuthorDTO {
    private int id;
    private String name;
    private String surname;
    private BookDTO bookDTO;
    private Set<PersonDTO> personDTOSett;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorDTO(String name, String surname, BookDTO bookDTO, Set<PersonDTO> personDTOSett) {
        this.name = name;
        this.surname = surname;
        this.bookDTO = bookDTO;
        this.personDTOSett = personDTOSett;
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

    public Set<PersonDTO> getPersonDTOSett() {
            return personDTOSett;
    }

    public void setPersonDTOSett(Set<PersonDTO> personDTOSett) {
        this.personDTOSett = personDTOSett;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
