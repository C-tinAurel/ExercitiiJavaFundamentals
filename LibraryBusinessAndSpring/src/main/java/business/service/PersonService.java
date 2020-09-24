package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.PersonDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.PersonDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Person;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    public List<PersonDTO> findPersonByName(String name) {
        List<Person> personList = personDAO.findPersonByName(name);
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
        for (Person person : personList) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setName(person.getName());
            personDTOList.add(personDTO);
        }
        return personDTOList;
    }

    public void insert(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setAddress(personDTO.getAddress());
        Set<Book> bookSet = new HashSet<>();
        for (BookDTO bookDTO : personDTO.getBookDTOS()) {
            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            book.setVolumNumber(bookDTO.getVolumNumber());
            book.setGender(bookDTO.getGender());
            bookSet.add(book);
        }
        Set<Section> sectionSet = new HashSet<>();
        for (SectionDTO sectionDTO : personDTO.getSectionDTO()) {
            Section section = new Section();
            section.setName(sectionDTO.getName());
            sectionSet.add(section);
        }

        person.setBooks(bookSet);
        person.setSections(sectionSet);
        personDAO.insert(person);
    }
}
