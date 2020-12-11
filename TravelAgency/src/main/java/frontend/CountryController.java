package frontend;

import business.dto.CountryDTO;
import business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @PostMapping(path = "/insertCountry")
    public ResponseEntity insertCountry(@RequestBody @Valid CountryDTO countryDTO) {
        if(countryService.findCountry(countryDTO.getName())==null){
            countryService.insertCountry(countryDTO);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Tara " +countryDTO.getName() + " exista in baza de date");
    }

    @GetMapping(path = "/findCountry")
    public String findCountry(@RequestParam String name) {
       CountryDTO countryDTO= countryService.findCountry(name);
        if (countryDTO==null){
            return "Nu a fost gasita Tara " +name ;
        }
        return "Tara: " + countryDTO.getName() + " exista in baza de date";
    }
}
