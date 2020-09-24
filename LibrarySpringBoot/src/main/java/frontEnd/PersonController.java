package frontEnd;

import business.dto.PersonDTO;
import business.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping(path = "/personInsert")
    public String insertPerson(@RequestBody PersonDTO personInsert) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(personInsert.getName());
        personDTO.setSurname(personInsert.getSurname());
        personDTO.setAddress(personInsert.getAddress());
        personDTO.setYearOfBirth(personInsert.getYearOfBirth());
        personDTO.setBookDTOSet(personInsert.getBookDTOSet());
        personDTO.setSectionDTOSet(personInsert.getSectionDTOSet());
        personService.insertPerson(personInsert);

        return "Am introdus persoana " + personInsert.getName() + " " + personInsert.getSurname();
    }

    @PutMapping(path = "/updatePerson")
    public String updatePersonByAddress(@RequestParam String address,@RequestParam String name){
        System.out.println("Schimbam adresa persoanei " +name);
        Integer numberUpdatedPerson=personService.updatePersonAfterAddress(address,name);
        if(numberUpdatedPerson>0){
            return "Am actualizat cu succes persoana";
        }else {
            return "Mai incearca";
        }
    }
    @DeleteMapping(path = "/deletePerson")
    public String deletePersonByYearOfBirth(@RequestParam int yearOfBirth){
        Integer numberDeletedPerson= personService.deletePersonByYearOfBirth(yearOfBirth);
        if(numberDeletedPerson>0){
            return "Am sters cu succes persoana";
        }else {
            return "Mai incearca";
        }
    }
@GetMapping(path = "/findPerson")
    public List<PersonDTO> findPersonByName(@RequestParam String name){
        List<PersonDTO> personDTOList=personService.findPersonByName(name);
        return personDTOList;
    }
}
