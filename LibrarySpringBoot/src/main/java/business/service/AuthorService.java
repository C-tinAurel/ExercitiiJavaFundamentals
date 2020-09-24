package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.PersonDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AuthorDAO;
import persistence.dao.PersonDAO;
import persistence.entitites.Author;
import persistence.entitites.Book;
import persistence.entitites.Person;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    @Autowired
    AuthorDAO authorDAO;
;


    public void insertAutor(AuthorDTO authorDTO) {
        Book book = new Book();
        book.setTitle(authorDTO.getBookDTO().getTitle());
        Set<Person> personSet = new HashSet<>();
        for (PersonDTO personDTO : authorDTO.getPersonDTOSett()) {
            Person person = new Person();
            person.setName(personDTO.getName());
            person.setSurname(personDTO.getSurname());
            person.setYearOfBirth(personDTO.getYearOfBirth());
            person.setAddress(personDTO.getAddress());
            personSet.add(person);
        }
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setBook(book);
        author.setPersonSet(personSet);
        authorDAO.insert(author);
    }

    public List<AuthorDTO> findAutorByName(String name) {
        List<Author> authorList = authorDAO.findAuthorByName(name);
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        BookDTO bookDTO=new BookDTO();
        for (Author author : authorList) {
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(author.getName());
            authorDTO.setSurname(author.getSurname());
            bookDTO.setTitle(author.getBook().getTitle());
            authorDTO.setBookDTO(bookDTO);

            authorDTOS.add(authorDTO);
        }

        return authorDTOS;
    }

    public Integer deleteAutorByName(String name) {
        Integer deleteAuthorsByName = authorDAO.deleteAuthorByName(name);
        return deleteAuthorsByName;
    }

    public Integer updateAuthorSurname(String surname, String name) {
        Integer updateAuthorSurname = authorDAO.updateAuthorSurname(surname, name);
        return updateAuthorSurname;
    }

}
