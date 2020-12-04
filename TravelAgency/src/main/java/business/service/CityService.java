package business.service;

import business.dto.CityDTO;
import business.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.entities.City;
import persistence.entities.Country;

@Service
public class CityService {

    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryService countryService;


    public void insertCity(CityDTO cityDTO) {
        City city = new City();
        City cityFound = cityDAO.findCity(cityDTO.getName());
        Country countryFound = countryService.setCountry(cityDTO.getCountryDTO());
        if (cityFound == null) {
            city.setName(cityDTO.getName());
            city.setCountry(countryFound);
            cityDAO.insertCity(city);
        } else if (city.getName().equalsIgnoreCase(cityDTO.getCountryDTO().getName())) {
            city.setName(cityFound.getName());
            city.setCountry(countryFound);
            city.setId(city.getId());
        }
    }

    public CityDTO findCountry(String name){
        City city=cityDAO.findCity(name);
        CityDTO cityDTO=new CityDTO();
        cityDTO.setName(city.getName());
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName(city.getCountry().getName());
        cityDTO.setCountryDTO(countryDTO);
        return cityDTO;
    }

    public Integer deleteCity(String name){
        Integer updatedRow=cityDAO.deleteCityByName(name);
        return updatedRow;
    }

    public City setCity(CityDTO cityDTO){
        City city=new City();
        City cityFound=cityDAO.findCity(cityDTO.getName());
        Country countryFound=countryService.setCountry(cityDTO.getCountryDTO());
        if(cityFound==null){
            city.setName(cityDTO.getName());
            city.setCountry(countryFound);
        }else if(cityFound.getName().equalsIgnoreCase(cityDTO.getName())){
            city.setName(cityFound.getName());
            city.setCountry(countryFound);
            city.setId(city.getId());
        }
        return city;
    }
}
