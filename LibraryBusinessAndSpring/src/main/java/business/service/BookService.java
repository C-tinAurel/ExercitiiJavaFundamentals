package business.service;

import business.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.BookDAO;
import persistence.entities.Book;

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
        book.setBorrowed(bookDTO.isBorrowed());
        book.setAuthor(bookDTO.getAuthor());
        book.setFreeBook(bookDTO.isFreeBook());
        book.setGender(bookDTO.getGender());
        book.setVolumNumber(bookDTO.getVolumNumber());
        book.setSection(bookDTO.getSection());
        bookDAO.insert(book);

    }

}
