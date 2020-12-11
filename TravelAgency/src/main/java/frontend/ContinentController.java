package frontend;

import business.dto.ContinentDTO;
import business.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import persistence.entities.Continent;

import javax.validation.Valid;


@RestController
public class ContinentController {
    @Autowired
    ContinentService continentService;

    @PostMapping(path = "/insertContinent")
    public ResponseEntity insertContinent(@RequestBody @Valid ContinentDTO continentDTO) {
        if (continentService.findContinent(continentDTO.getName()) == null) {
            continentService.insertContinent(continentDTO);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Continentul " + continentDTO.getName() + " exista in baza de date");
    }

    @GetMapping(path = "/findContinent")
    public String findContinent(@RequestParam String name) {
        ContinentDTO continentDTO=continentService.findContinent(name);
        if(continentDTO==null){
            return "Nu a fost gasit Continentul ";
        }
        return "Continentul: " + name + " exista in baza de date";
}


}