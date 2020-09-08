package business.service;

import business.dto.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.SectionDAO;
import persistence.entities.Section;

import java.util.ArrayList;
import java.util.List;

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
        section.setAuthors(sectionDTO.getAuthors());
        section.setBook(sectionDTO.getBooks());
        sectionDAO.insert(section);
    }
}
