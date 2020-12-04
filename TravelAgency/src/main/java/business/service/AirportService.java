package business.service;

import business.dto.AirportDTO;
import business.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.entities.Airport;
import persistence.entities.City;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportDAO airportDAO;
    @Autowired
    CityService cityService;

    public void insertAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        Airport airportFound = airportDAO.findAirportByName(airportDTO.getName());
        City cityFound = cityService.setCity(airportDTO.getCityDTO());
        if (airportFound == null) {
            airport.setName(airportDTO.getName());
            airport.setCity(cityFound);
            airportDAO.insertAirport(airport);
        } else if (airportFound.getName().equalsIgnoreCase(airportDTO.getName())) {
            airport.setName(airportFound.getName());
            airport.setCity(cityFound);
            airport.setId(airport.getId());
        }
    }

    public Airport setAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        Airport airportFound = airportDAO.findAirportByName(airportDTO.getName());
        City cityFound = cityService.setCity(airportDTO.getCityDTO());
        if (airportFound == null) {
            airport.setName(airportDTO.getName());
            airport.setCity(cityFound);
            airportDAO.insertAirport(airport);
        } else if (airportFound.getName().equalsIgnoreCase(airportDTO.getName())) {
            airport.setName(airportFound.getName());
            airport.setCity(cityFound);
            airport.setId(airportFound.getId());
        }
        return airport;
    }

    public AirportDTO findAirportByName(String name) {
        Airport airport = airportDAO.findAirportByName(name);
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

    public Integer updateAirportName(String newName,String name){
        Integer updatedRow=airportDAO.updateAirportName(newName, name);
        return updatedRow;
    }
}

