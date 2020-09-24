package entryPoint;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.PersonDTO;
import business.dto.SectionDTO;
import business.service.AuthorService;
import business.service.BookService;
import business.service.PersonService;
import business.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class LibraryEntryPoint {
    @Autowired
    PersonService personService;
    @Autowired
    BookService bookService;
    @Autowired
    SectionService sectionService;
    @Autowired
    AuthorService authorService;

    public void run() {

        AuthorDTO authorDTO1 = new AuthorDTO("Barbu", "Stefanescu de la Vrancea");
        SectionDTO sectionDTO = new SectionDTO("Zona B");
        SectionDTO sectionDTO1 = new SectionDTO("Zona C");
        Set<SectionDTO> sectionDTOSet = new HashSet<>();
        sectionDTOSet.add(sectionDTO);
        sectionDTOSet.add(sectionDTO1);

        BookDTO bookDTO = new BookDTO("Amintiri Din Copilarie", 1, "Literatura", false, true,authorDTO1,sectionDTO);
        BookDTO bookDTO1 = new BookDTO("Implinire", 1, "Dragoste", true, true,authorDTO1,sectionDTO);
        Set<BookDTO> bookDTOSet = new HashSet<>();
        bookDTOSet.add(bookDTO);
        bookDTOSet.add(bookDTO1);

        PersonDTO personDTO = new PersonDTO("Luca", "Gigi", "Iasi", 2000);
        PersonDTO personDTO1 = new PersonDTO("Niculae", "Marius", "Galati", 1998);
        PersonDTO personDTO2 = new PersonDTO("Mirel", "Radoi", "Bucuresti", 1995);
        Set<PersonDTO> personDTOSet = new HashSet<PersonDTO>();
        personDTOSet.add(personDTO);
        personDTOSet.add(personDTO1);
        personDTOSet.add(personDTO2);


        // AuthorDTO insertAuthor = new AuthorDTO("Ion-Luca", "Caragiale", bookDTO1, personDTOSet);
       //BookDTO insertBook = new BookDTO("Sperante", 1, "epic", true, true, authorDTO1, sectionDTO);
        PersonDTO insertPerson = new PersonDTO("Laurentiu", "Iulian", "Bucuresti", 2000, bookDTOSet, sectionDTOSet);
        //Introducem un Autor:
        //  authorService.insert(authorDTO);
       //  personService.insert(insertPerson); mai incearca
       // bookService.insert(insertBook);

    }


}


