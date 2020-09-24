package business.service;

import business.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.BookDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> findTitleBook(String title){
        List<Book> bookList=bookDAO.findTitleBook(title);
        List<BookDTO> bookDTOList=new ArrayList<BookDTO>();
        for(Book books:bookList){
            BookDTO bookDTO=new BookDTO();
            bookDTO.setTitle(books.getTitle());
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
    public void insert(BookDTO bookDTO){
        Book book=new Book();
        book.setTitle(bookDTO.getTitle());
        book.setGender(bookDTO.getGender());
        Author author=new Author();
        author.setName(bookDTO.getAuthorDTO().getName());
        author.setSurname(bookDTO.getAuthorDTO().getSurname());
        Section section=new Section();
        section.setName(bookDTO.getSectionDTO().getName());
        book.setAuthor(author);
        book.setSection(section);
        bookDAO.insert(book);

    }

}
