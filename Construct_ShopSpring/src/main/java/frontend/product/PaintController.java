package frontend.product;

import business.dto.product.PaintDTO;
import business.service.product.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PaintController {

    @Autowired
    PaintService paintService;

    @PostMapping(path = "/insertPaint")
    public String insertPaint(@RequestBody @Valid PaintDTO paintDTO) {
        paintService.insertPaint(paintDTO);
        return "Ati introdus vopseau cu succes";
    }

    @GetMapping(path = "/findPaint")
    public List<PaintDTO> findPaintColor(@RequestParam String color) {
        List<PaintDTO> paintDTOList = paintService.findPaintByColor(color);
        return paintDTOList;
    }

    @PutMapping(path = "/updatePaint")
    public String updatePaint(@RequestParam String mark, @RequestParam String name) {
        Integer updatedPaint = paintService.updatedPaintMark(mark, name);
        PaintDTO paintDTO = new PaintDTO();
        if (updatedPaint > 0) {
            return "Am actualizat cu succes " + paintDTO.getName();
        } else {
            return "Nu s-a actualizat :(";
        }
    }

    @DeleteMapping(path = "/deletePaint")
    public String deletePaint(@RequestParam String color) {
        Integer deletedPaint = paintService.deletePaintColor(color);
        if (deletedPaint > 0) {
            return "Ati sters cu succes";
        } else {
            return "Produsul nu a fost sters :(";
        }
    }
}
