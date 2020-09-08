package entryPoint;

import business.service.AuthorService;
import business.service.BookService;
import business.service.PersonService;
import business.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.entities.Book;
import persistence.entities.Person;

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
public void run(){





}

}
