package frontEnd;

import business.dto.AuthorDTO;
import business.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping(path = "/insertAuthor")
    public void insertAuthor(@RequestBody AuthorDTO insertAuthor) {
        AuthorDTO authorDTO=new AuthorDTO();
        authorDTO.setName(insertAuthor.getName());
        authorDTO.setSurname(insertAuthor.getSurname());
        authorService.insertAutor(authorDTO);
        System.out.println("Am introdus autorul : " + insertAuthor.getName() + " " + insertAuthor.getSurname() );
    }

    @PutMapping(path = "/updateAuthorSurname")
    public String updateAuthor(@RequestParam String name, @RequestParam String surname) {
        System.out.println("Autorul caruia i se va modifica prenumele este " + name);
      Integer updateSurnameAuthor= authorService.updateAuthorSurname(name,surname);
        System.out.println("Prenume schimbat " + surname);
        if(updateSurnameAuthor>0){
            return "Autorul a fost actualizat";
        }else {
            return "Nu a fost actualizat autorul";
        }
    }
    @GetMapping(path = "/findAuthorByName")
    public List<AuthorDTO> findAuthorByName(@RequestParam String name) {
        System.out.println("Numele Autorului dupa care cautam " + name);
        List<AuthorDTO> authorDTOS=authorService.findAutorByName(name);
        return  authorDTOS;
    }

    @DeleteMapping(path = "/deleteAuthorbyName")
    public String deleteAuthorByName(@RequestParam String name) {
        System.out.println("Autorul sters este " + name);
        authorService.deleteAutorByName(name);
        return "Autorul " + name + " a fost sters cu succes";
    }
}
