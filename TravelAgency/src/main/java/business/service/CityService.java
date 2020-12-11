package business.service;

import business.dto.CityDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.entities.City;
import persistence.entities.Continent;
import persistence.entities.Country;

@Service
public class CityService {

    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    CountryService countryService;


    public void insertCity(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        setCountry(city,cityDTO);
        cityDAO.insertCity(city);

    }

    public void setCountry(City city,CityDTO cityDTO){
        Country countryFound=countryDAO.findCountry(cityDTO.getCountryDTO().getName());
        if(countryFound==null){
            Country country=new Country();
            country.setName(cityDTO.getCountryDTO().getName());
            countryService.setContinent(country,cityDTO.getCountryDTO());
            city.setCountry(country);
        }else {
            city.setCountry(countryFound);
        }
    }

    public CityDTO findCity(String name) {
        City city = cityDAO.findCity(name);
        if(city==null){
            return null;
        }
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(city.getName());
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(city.getCountry().getName());
        cityDTO.setCountryDTO(countryDTO);
        return cityDTO;
    }

    public Integer deleteCity(String name) {
        Integer updatedRow = cityDAO.deleteCityByName(name);
        return updatedRow;
    }



}
