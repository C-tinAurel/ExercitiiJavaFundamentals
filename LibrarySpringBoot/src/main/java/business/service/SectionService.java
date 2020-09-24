package business.service;

import business.dto.AuthorDTO;
import business.dto.BookDTO;
import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.SectionDAO;
import persistence.entitites.Author;
import persistence.entitites.Book;
import persistence.entitites.Section;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SectionService {
    @Autowired
    SectionDAO sectionDAO;

    public void insertSection(SectionDTO sectionDTO){
       Set<Author> authorSet=new HashSet<>();
        Author author=new Author();
        for(AuthorDTO authorDTO :sectionDTO.getAuthorDTOSet()){
            author.setName(authorDTO.getName());
            author.setSurname(authorDTO.getSurname());
            authorSet.add(author);
        }

        Section section=new Section();
        Set<Book> bookSet=new HashSet<>();
        for(BookDTO bookDTO:sectionDTO.getBookDTOSet()){
            Book book=new Book();
            book.setTitle(bookDTO.getTitle());
            book.setSection(section);
            book.setAuthor(author);
            bookSet.add(book);
        }
        section.setAuthorSet(authorSet);
        section.setBooks(bookSet);
     //   Section section=new Section();
        section.setName(sectionDTO.getName());
        sectionDAO.insert(section);
    }
    public Integer deleteDeleteSectionByName(String name){
        Integer deleteSectionRow=sectionDAO.deleteSectionByName(name);
        return deleteSectionRow;
    }
    public List<SectionDTO> findSectionByName(String name){
        List<Section> sectionList=sectionDAO.findSectionByName(name);
        List<SectionDTO> sectionDTOList=new ArrayList<>();
        for(Section section:sectionList){
            SectionDTO sectionDTO=new SectionDTO();
            sectionDTO.setName(section.getName());
            sectionDTOList.add(sectionDTO);
        }
        return sectionDTOList;
    }
    public Integer updateSectionByAuthor(String name,Set<AuthorDTO> authorDTOSet){
        Set<Author> authorSet=new HashSet<>();
        for(AuthorDTO authorDTO:authorDTOSet){
            Author author=new Author();
            author.setName(authorDTO.getName());
            author.setSurname(authorDTO.getSurname());
            authorSet.add(author);
        }
        Integer numberOfSectionUpdate=sectionDAO.updateSectionByAuthor(authorSet,name);
        return numberOfSectionUpdate;
    }
}
