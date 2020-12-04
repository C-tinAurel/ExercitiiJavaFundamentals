package frontend;

import business.dto.ContinentDTO;
import business.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ContinentController {
    @Autowired
    ContinentService continentService;

    @PostMapping(path = "/insertContinent")
    public String insertContinent(@RequestBody @Valid ContinentDTO continentDTO) {
        continentService.insertContinent(continentDTO);
        return "Ati introdus cu succes Continentul : " + continentDTO.getName();
    }

    @GetMapping(path = "/findContinent")
    public ContinentDTO findContinent(@RequestParam String name) {
        ContinentDTO continentDTO = continentService.findContinent(name);
        return continentDTO;
    }
}
