package frontend;

import business.dto.CountryDTO;
import business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @PostMapping(path = "/insertCountry")
    public String insertCountry(@RequestBody @Valid CountryDTO countryDTO) {
        countryService.insertCountry(countryDTO);
        return "Ati introdus cu succes Tara : " + countryDTO.getName();
    }

    @GetMapping(path = "/findCountry")
    public CountryDTO findCountry(@RequestParam String name) {
       CountryDTO countryDTO= countryService.findCountry(name);
        return countryDTO;
    }
}
