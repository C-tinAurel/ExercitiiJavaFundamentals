package business.service;

import business.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AuthorDAO;
import persistence.entities.Author;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    public List<AuthorDTO> findByName(AuthorDTO authorDTO) {
        List<Author> authorList = authorDAO.findAuthorByName(authorDTO.getName());
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();
        for (Author authors : authorList) {
            AuthorDTO authorDTO1 = new AuthorDTO();
            authorDTO1.setName(authors.getName());
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    public void insert(AuthorDTO authorDTO) {
        Author author = new Author();
      author.setName(authorDTO.getName());
      author.setSurname(authorDTO.getSurname());
      author.setBook(authorDTO.getBook());
      author.setPersons(authorDTO.getPersons());
      authorDAO.insert(author);
    }
}
