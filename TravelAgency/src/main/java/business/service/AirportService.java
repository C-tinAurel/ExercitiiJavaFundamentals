package business.service;

import business.dto.AirportDTO;
import business.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.entities.Airport;
import persistence.entities.City;
import persistence.entities.Continent;
import persistence.entities.Country;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportDAO airportDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insertAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setName(airportDTO.getName());
        setCity(airportDTO, airport);
        airportDAO.insertAirport(airport);

    }

    public void setCity(AirportDTO airportDTO, Airport airport) {
        City city = new City();
        City cityFound = cityDAO.findCity(airportDTO.getCityDTO().getName());
        Country countryFound = countryDAO.findCountry(airportDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (cityFound == null) {
            city.setName(airportDTO.getCityDTO().getName());
            city.setCountry(countryFound);
            airport.setCity(city);
        } else {
            airport.setCity(cityFound);
        }
    }


    public AirportDTO findAirportByName(String name) {
        Airport airport = airportDAO.findAirportByName(name);
        if (airport == null) {
            return null;
        }
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(airport.getName());
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(airport.getCity().getName());
        airportDTO.setCityDTO(cityDTO);
        return airportDTO;
    }


    public List<AirportDTO> findAirportByCity(String cityName) {
        List<Airport> airportList = airportDAO.findAirportByCity(cityName);
        List<AirportDTO> airportDTOList = new ArrayList<>();
        for (Airport airport : airportList) {
            AirportDTO airportDTO = new AirportDTO();
            airportDTO.setName(airport.getName());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(airport.getCity().getName());
            airportDTO.setCityDTO(cityDTO);
            airportDTOList.add(airportDTO);
        }
        return airportDTOList;
    }

    public Integer updateAirportName(String newName, String name) {
        Integer updatedRow = airportDAO.updateAirportName(newName, name);
        return updatedRow;
    }
}

