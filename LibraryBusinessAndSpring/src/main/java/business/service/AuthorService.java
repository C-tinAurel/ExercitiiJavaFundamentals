package business.service;

import business.dto.AuthorDTO;
import business.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AuthorDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    public List<AuthorDTO> findByName(AuthorDTO authorDTO) {
        List<Author> authorList = authorDAO.findAuthorByName(authorDTO.getName());
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();
        for (Author authors : authorList) {
            AuthorDTO authorDTO1 = new AuthorDTO();
            authorDTO1.setName(authors.getName());
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    public void insert (AuthorDTO authorDTO){
      Author author=new Author();
      author.setName(authorDTO.getName());
      author.setSurname(authorDTO.getSurname());
      Book book=new Book();
      book.setTitle(authorDTO.getBookDTO().getTitle());
     Set<Person> personSet=new HashSet<>();
     for (PersonDTO personDTO:authorDTO.getPersonsDTO()){
         Person person = new Person();
         person.setName(personDTO.getName());
         person.setSurname(personDTO.getSurname());
         person.setAddress(personDTO.getAddress());
         personSet.add(person);
     }
     author.setPersons(personSet);
     authorDAO.insert(author);
    }
}
