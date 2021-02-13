package frontend.product;

import business.dto.product.DrillDTO;
import business.service.product.DrillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DrillController {
    @Autowired
    DrillService drillService;

    @PostMapping(path = "/insertDrill")
    public String insertDrill(@RequestBody @Valid DrillDTO drillDTO) {
        drillService.insertDrillDTO(drillDTO);
        return "Ati introdus bormasina cu succes";
    }

    @GetMapping(path = "/findDrill")
    public List<DrillDTO> findDrillByMark(@RequestParam String mark) {
        List<DrillDTO> drillDTOList = drillService.findDrillDTOMark(mark);
        return drillDTOList;
    }

    @DeleteMapping(path = "/deleteMark")
    public String deleteDrillByMark(@RequestParam String mark) {
        Integer numberDeleted = drillService.deleteDrillByMark(mark);
        if (numberDeleted > 0) {
            return "Articolul a fost sters cu succes ";
        } else {
            return "Articoulul nu a fost sters :(";
        }
    }

    @PutMapping(path = "/updateDrill")
    public String updateDrillMark(@RequestParam String mark, @RequestParam String name) {
        Integer numberUpdated = drillService.updateDrillMark(mark, name);
        if (numberUpdated > 0) {
            return "Ati actualizat articolul cu succes";
        } else {
            return "Actualizare ne reusita :(";
        }
    }
}
