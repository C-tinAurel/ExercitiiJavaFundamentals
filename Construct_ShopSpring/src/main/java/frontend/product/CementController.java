package frontend;

import business.dto.CementDTO;
import business.service.CementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CementController {
    @Autowired
    CementService cementService;

    @PostMapping(path = "/insertCement")
    public String insertCement(@RequestBody CementDTO insertCement) {
        CementDTO cementDTO = new CementDTO();
        cementDTO.setName(insertCement.getName());
        cementDTO.setGranulation(insertCement.getGranulation());
        cementDTO.setPrice(insertCement.getPrice());
        cementDTO.setStock(insertCement.getStock());
        cementDTO.setDepartmentDTO(insertCement.getDepartmentDTO());
        cementDTO.setDepositDTOSet(insertCement.getDepositDTOSet());
        cementService.insert(cementDTO);
        return "Am introdus Cimentul: " + insertCement.getName();
    }

    @GetMapping(path = "/findCement")
    public List<CementDTO> findCementName(@RequestParam String name) {
        List<CementDTO> cementDTOList = cementService.findCementByName(name);
        return cementDTOList;
    }

    @PutMapping(path = "/updateCement")
    public String updateCementByGranulation(@RequestParam String granulation, @RequestParam String name) {
        Integer updatedCementRow = cementService.updateCementGranulation(granulation, name);
        if (updatedCementRow > 0) {
            return "Am actualiza cu succes rubrica Ciment";
        } else {
            return "Actualizare nereusita :(";
        }
    }

    @DeleteMapping(path = "/deleteCement")
    public String deleteCementByGranulation(@RequestParam String granulation) {
        Integer deletedCementRow = cementService.deleteCementGranulation(granulation);
        if (deletedCementRow > 0) {
            return "Ati actualizat cu succes rubrica Ciment";
        } else {
            return "Actualizare esuata :(";
        }
    }
}
