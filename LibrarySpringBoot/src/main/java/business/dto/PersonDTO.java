package business.dto;

import java.util.Set;

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int yearOfBirth;
    private Set<BookDTO> bookDTOSet;
    private Set<SectionDTO> sectionDTOSet;

    public PersonDTO() {
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth, Set<BookDTO> bookDTOSet, Set<SectionDTO> sectionDTOSet) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.bookDTOSet = bookDTOSet;
        this.sectionDTOSet = sectionDTOSet;
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

    public Set<BookDTO> getBookDTOSet() {
        return bookDTOSet;
    }

    public void setBookDTOSet(Set<BookDTO> bookDTOSet) {
        this.bookDTOSet = bookDTOSet;
    }

    public Set<SectionDTO> getSectionDTOSet() {
        return sectionDTOSet;
    }

    public void setSectionDTOSet(Set<SectionDTO> sectionDTOSet) {
        this.sectionDTOSet = sectionDTOSet;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

