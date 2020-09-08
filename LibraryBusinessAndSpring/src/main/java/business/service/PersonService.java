package business.service;

import business.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.PersonDAO;
import persistence.entities.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

     public List<PersonDTO> findPersonByName(String name){
         List<Person> personList=personDAO.findPersonByName(name);
         List<PersonDTO> personDTOList=new ArrayList<PersonDTO>();
         for(Person person :personList){
             PersonDTO personDTO=new PersonDTO();
             personDTO.setName(person.getName());
             personDTOList.add(personDTO);
         }
         return personDTOList;
     }

     public void insert(PersonDTO personDTO){
         Person person=new Person();
         person.setName(personDTO.getName());
         person.setSurname(personDTO.getSurname());
         person.setAddress(personDTO.getAddress());
         person.setBooks(personDTO.getBooks());
         person.setSections(personDTO.getSections());
         person.setYearOfBirth(personDTO.getYearOfBirth());
         personDAO.insert(person);

     }
}
