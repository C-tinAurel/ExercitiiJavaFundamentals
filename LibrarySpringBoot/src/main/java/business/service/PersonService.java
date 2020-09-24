package business.service;

import business.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.PersonDAO;
import persistence.entitites.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDAO personDAO;

    public void insertPerson(PersonDTO personDTO){
        Person person=new Person();
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setAddress(personDTO.getAddress());
        person.setYearOfBirth(personDTO.getYearOfBirth());
        personDAO.insert(person);
    }
    public Integer deletePersonByYearOfBirth(int yearOfBirth){
        Integer numberOfDeletingPersonByYearOfBirth= personDAO.deletePersonByYearOfBirth(yearOfBirth);
        return numberOfDeletingPersonByYearOfBirth;

    }
    public List<PersonDTO> findPersonByName(String name){
        List<Person> personList=personDAO.findPersonByName(name);
        List<PersonDTO> personDTOList=new ArrayList<>();
        for(Person person:personList){
            PersonDTO personDTO=new PersonDTO();
            personDTO.setName(person.getName());
            personDTO.setSurname(person.getSurname());
            personDTO.setAddress(person.getAddress());
            personDTO.setYearOfBirth(person.getYearOfBirth());
            personDTOList.add(personDTO);
        }
        return personDTOList;
    }
    public Integer updatePersonAfterAddress(String address,String name){
        Integer numberOfPersonUpdatedByAddress=personDAO.updatePersonByAddress(address,name);
        return numberOfPersonUpdatedByAddress;
    }


}
