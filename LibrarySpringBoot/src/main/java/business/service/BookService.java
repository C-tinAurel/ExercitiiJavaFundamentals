package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.BookDAO;
import persistence.entitites.Author;
import persistence.entitites.Book;
import persistence.entitites.Section;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;

    public void insert(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setGender(bookDTO.getGender());
        book.setVolumNumber(bookDTO.getVolumNumber());
        Section section=new Section();
        section.setName(bookDTO.getSectionDTO().getName());
        book.setSection(section);
        Author author=new Author();
        author.setName(bookDTO.getAuthorDTO().getName());
        author.setSurname(bookDTO.getAuthorDTO().getSurname());
        book.setAuthor(author);
        bookDAO.insert(book);
    }

    public void deleteBookByVolumNumber(int volumNumber) {
        bookDAO.deleteBookByVolumNumber(volumNumber);
    }

    public List<BookDTO> findBookByTitle(String title) {
        List<Book> bookList = bookDAO.findBookByTitle(title);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setBorrowed(book.isBorrowed());
            bookDTO.setFreeBook(book.isBorrowed());
            bookDTO.setGender(book.getGender());
            bookDTO.setVolumNumber(book.getVolumNumber());
            AuthorDTO authorDTO=new AuthorDTO();
            authorDTO.setName(book.getAuthor().getName());
            authorDTO.setSurname(book.getAuthor().getSurname());
            bookDTO.setAuthorDTO(authorDTO);
            SectionDTO sectionDTO=new SectionDTO();
            sectionDTO.setName(book.getSection().getName());
            bookDTO.setSectionDTO(sectionDTO);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public Integer updateBookByGender(String gender, String title) {
        Integer numberOfUpdatedBook = bookDAO.updateBookByGender(gender, title);
        return numberOfUpdatedBook;
    }

}
