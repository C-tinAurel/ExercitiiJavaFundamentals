package business.service;

import business.dto.ContinentDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CountryDAO;
import persistence.entities.Continent;
import persistence.entities.Country;



@Service
public class CountryService {
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentService continentService;


    public void insertCountry(CountryDTO countryDTO) {
        Country country = new Country();
        Country countryFound = countryDAO.findCountry(countryDTO.getName());
        Continent continentFound = continentService.setContinent(countryDTO.getContinentDTO());
        if (countryFound == null) {
            country.setName(countryDTO.getName());
            country.setContinent(continentFound);
            countryDAO.insertCountry(country);
        } else if (countryFound.getName().equalsIgnoreCase(countryDTO.getName())) {
            country.setName(countryFound.getName());
            country.setContinent(continentFound);
            country.setId(continentFound.getId());
        }
    }

    public CountryDTO findCountry(String name) {
        Country country = countryDAO.findCountry(name);
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(country.getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
        return countryDTO;
    }

    public Country setCountry(CountryDTO countryDTO) {
        Country country = new Country();
        Country countryFound = countryDAO.findCountry(countryDTO.getName());
        Continent continentFound=continentService.setContinent(countryDTO.getContinentDTO());
        if (countryFound == null) {
            country.setName(countryDTO.getName());
            country.setContinent(continentFound);
            countryDAO.insertCountry(country);
        } else if (!countryFound.getName().equalsIgnoreCase(countryDTO.getName())) {
            country.setName(countryFound.getName());
            country.setContinent(continentFound);
            country.setId(countryFound.getId());
        }
        return country;
    }
}
