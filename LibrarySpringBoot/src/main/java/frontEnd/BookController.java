package frontEnd;

import business.dto.BookDTO;
import business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping(path = "/insertBook")
    public String insertBook(@RequestBody BookDTO insertBook) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(insertBook.getTitle());
        bookDTO.setVolumNumber(insertBook.getVolumNumber());
        bookDTO.setGender(insertBook.getGender());
        bookDTO.setSectionDTO(insertBook.getSectionDTO());
        bookDTO.setAuthorDTO(insertBook.getAuthorDTO());
        bookService.insert(bookDTO);
        return "Ati introdus cartea cu titlul " + insertBook.getTitle();
    }

    @DeleteMapping(path = "/deleteBook")
    public void deleteBookByVolumNumber(@RequestParam int volumNumber) {
        bookService.deleteBookByVolumNumber(volumNumber);

    }

    @PutMapping(path = "/updateBook")
    public String updateBookByGender(@RequestParam String gender, @RequestParam String title) {
        Integer numberUpdatedBook = bookService.updateBookByGender(gender, title);
        if (numberUpdatedBook > 0) {
            return "Cartea a fost actualizata cu succes";
        } else {
            return "Cartea nu a fost actualizata inca";
        }
    }
     @GetMapping(path = "/findBook")
    public List<BookDTO> findBookByTitle(@RequestParam String title){
        List<BookDTO> bookDTOList = bookService.findBookByTitle(title);
        return bookDTOList;
    }

}
