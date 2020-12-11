package frontend;

import business.dto.CityDTO;
import business.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @PostMapping(path = "/insertCity")
    public ResponseEntity insertCity(@RequestBody @Valid CityDTO cityDTO){
       if(cityService.findCity(cityDTO.getName())==null){
           cityService.insertCity(cityDTO);
       }
       return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Orasul " +cityDTO.getName() + " exista in baza de date");
    }

    @GetMapping(path = "/findCity")
    public String findCity(@RequestParam String name){
        CityDTO cityDTO=cityService.findCity(name);
        if(cityDTO==null){
            return "Nu a fost gasit Orasul: " +name;
        }
        return "Orasul: " +cityDTO.getName() + " exista in baza de date";
    }

   @DeleteMapping(path = "/deleteCity")
    public String deleteCity(@RequestParam String name){
        Integer updatedRow=cityService.deleteCity(name);
        if(updatedRow>0){
            return "Orasul a fost sters cu succes";
        }
        return "Orasul nu a fost sters";
    }
}
