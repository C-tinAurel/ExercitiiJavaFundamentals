package frontend.product;

import business.dto.product.CementDTO;
import business.service.product.CementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CementController {
    @Autowired
    CementService cementService;

    @PostMapping(path = "/insertCement")
    public String insertCement(@RequestBody @Valid CementDTO cementDTO) {
        cementService.insert(cementDTO);
        return "Am introdus cimentul cu succes " ;
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
