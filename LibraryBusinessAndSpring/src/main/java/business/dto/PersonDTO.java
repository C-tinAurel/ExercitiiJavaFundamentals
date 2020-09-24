package business.dto;

import java.util.Set;

public class PersonDTO {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int yearOfBirth;
    private Set<BookDTO> bookDTOS;
    private Set<SectionDTO> sectionDTO;

    public PersonDTO() {
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
    }

    public PersonDTO(String name, String surname, String address, int yearOfBirth, Set<BookDTO> bookDTOS, Set<SectionDTO> sectionDTO) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.bookDTOS = bookDTOS;
        this.sectionDTO = sectionDTO;
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

    public Set<BookDTO> getBookDTOS() {
        return bookDTOS;
    }

    public void setBookDTOS(Set<BookDTO> bookDTOS) {
        this.bookDTOS = bookDTOS;
    }

    public Set<SectionDTO> getSectionDTO() {
        return sectionDTO;
    }

    public void setSectionDTO(Set<SectionDTO> sectionDTO) {
        this.sectionDTO = sectionDTO;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
