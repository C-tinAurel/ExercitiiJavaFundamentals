package frontEnd;

import business.dto.AuthorDTO;
import business.dto.SectionDTO;
import business.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.entitites.Author;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping(path = "/insertSection")
    public String insertSection(@RequestBody SectionDTO sectionInsert) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setName(sectionInsert.getName());
        sectionDTO.setAuthorDTOSet(sectionInsert.getAuthorDTOSet());
        sectionDTO.setBookDTOSet(sectionInsert.getBookDTOSet());
        sectionService.insertSection(sectionDTO);
        return "Ati introdus Sectiunea cu numele " + sectionInsert.getName();
    }

    @GetMapping(path = "/findSection")
    public List<SectionDTO> findSectionByName(@RequestParam String name) {
        List<SectionDTO> sectionDTOList = sectionService.findSectionByName(name);
        return sectionDTOList;
    }

    @DeleteMapping(path = "/deleteSection")
    public String deleteSectionByName(@RequestParam String name) {
        Integer numberOfDeleteSection = sectionService.deleteDeleteSectionByName(name);
        if (numberOfDeleteSection > 0) {
            return "Am sters sectiunea cu succes";
        } else {
            return "Nu s-a sters sectiunea,mai incearca";
        }
    }

    //nu am reusit sa probez functia update
    @PutMapping(path = "/updateSection")
    public String updateSectionByAuthor(@RequestParam Set<AuthorDTO> authorDTOSet, @RequestParam String name) {
        Integer numberUpdateSection = sectionService.updateSectionByAuthor(name, authorDTOSet);
        if (numberUpdateSection > 0) {
            return "Am actualizat sectiunea cu succes";
        } else {
            return "Mai incearca";
        }
    }
}