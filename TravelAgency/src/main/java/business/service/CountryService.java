package business.service;

import business.dto.ContinentDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.entities.Continent;
import persistence.entities.Country;



@Service
public class CountryService {
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;


    public void insertCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        setContinent(country,countryDTO);
        countryDAO.insertCountry(country);
    }

    public void setContinent(Country country,CountryDTO countryDTO) {
        Continent continentFound = continentDAO.findContinent(countryDTO.getContinentDTO().getName());
       if(continentFound==null){
           Continent continent = new Continent();
           continent.setName(country.getContinent().getName());
           country.setContinent(continent);
       }else{
           country.setContinent(continentFound);
       }
    }

    public CountryDTO findCountry(String name) {
        Country country = countryDAO.findCountry(name);
        if (country==null){
            return null;
        }
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(country.getContinent().getName());
        countryDTO.setContinentDTO(continentDTO);
        return countryDTO;
    }


}
