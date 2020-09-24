package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.SectionDAO;
import persistence.entities.Author;
import persistence.entities.Book;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SectionService {
    @Autowired
    private SectionDAO sectionDAO;


    public List<SectionDTO> findSectionByName(String name){
        List<Section> sectionList=sectionDAO.findSectionByName(name);
        List<SectionDTO> sectionDTOList=new ArrayList<SectionDTO>();
        for(Section section:sectionList){
         SectionDTO sectionDTO=new SectionDTO();
         sectionDTO.setName(section.getName());
         sectionDTOList.add(sectionDTO);
        }
        return sectionDTOList;
    }
   public void insert(SectionDTO sectionDTO){
        Section section=new Section();
        section.setName(sectionDTO.getName());
        Set<Author> authorSet=new HashSet<>();
        for(AuthorDTO authorDTO :sectionDTO.getAuthorDTOS()){
           Author author=new Author();
           author.setName(authorDTO.getName());
           author.setSurname(authorDTO.getSurname());
           authorSet.add(author);
        }
        Set<Book> bookSet=new HashSet<>();
        for(BookDTO bookDTO :sectionDTO.getBookDTOSet()){
            Book book =new Book();
            book.setTitle(bookDTO.getTitle());
            book.setGender(bookDTO.getGender());
            bookSet.add(book);
        }
        section.setAuthors(authorSet);
        section.setBook(bookSet);
        sectionDAO.insert(section);
    }
}
