package frontend;

import business.dto.CityDTO;
import business.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @PostMapping(path = "/insertCity")
    public String insertCity(@RequestBody @Valid CityDTO cityDTO){
        cityService.insertCity(cityDTO);
        return "Ati introdus cu succes Orasul : " +cityDTO.getName();
    }

    @GetMapping(path = "/findCity")
    public CityDTO findCity(@RequestParam String name){
        CityDTO cityDTO=cityService.findCountry(name);
        return cityDTO;
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
