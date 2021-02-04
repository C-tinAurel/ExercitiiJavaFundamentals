package business.service;

import business.dto.AirportDTO;
import business.dto.FlightDTO;
import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightDAO flightDAO;
    @Autowired
    AirportDAO airportDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    ContinentDAO continentDAO;

    public void insertFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setAvailableSeat(flightDTO.getAvailableSeat());
        flight.setPrice(flightDTO.getPrice());
        flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
        flight.setFlightDataAndTimeDeparture(flightDTO.getFlightDataAndTimeDeparture());
        setAirport(flightDTO, flight);

        flightDAO.insertFlight(flight);
    }


    public void setAirport(FlightDTO flightDTO, Flight flight) {
        Airport airport=null;
         airport = airportDAO.findAirportByName(flightDTO.getAirportDTO().getName());
        if (airport == null) {
            airport = new Airport();
            airport.setName(flightDTO.getAirportDTO().getName());
            setCity(flightDTO,airport);
            flight.setAirport(airport);

        }
    }

    public void setCity(FlightDTO flightDTO, Airport airport) {
        City cityFound=null;
        cityFound = cityDAO.findCity(flightDTO.getAirportDTO().getCityDTO().getName());
        if (cityFound == null) {
            cityFound = new City();
            cityFound.setName(flightDTO.getAirportDTO().getCityDTO().getName());
            airport.setCity(cityFound);
            setCountry(flightDTO, cityFound);
        }
    }

    public void setCountry(FlightDTO flightDTO, City city) {
        Country countryFound = countryDAO.findCountry(flightDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
        if (countryFound== null) {
            Country  country = new Country();
            country.setName(flightDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
            city.setCountry(country);
            setContinent(flightDTO, country);
        }else{
            city.setCountry(countryFound);
            setContinent(flightDTO,countryFound);
        }
    }

    public void setContinent(FlightDTO flightDTO, Country country) {
         Continent continentFound = continentDAO.findContinent(flightDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (continentFound == null) {
           Continent continent=new Continent();
            continent.setName(flightDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setContinent(continent);
        }else{
            country.setContinent(continentFound);
        }

        }

    public List<FlightDTO> findFlightByAirport(String airportName) {
        List<Flight> flightList = flightDAO.findFlightByAirport(airportName);
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (Flight flight : flightList) {
            FlightDTO flightDTO = new FlightDTO();
            flightDTO.setFlightNumber(flight.getFlightNumber());
            flightDTO.setPrice(flight.getPrice());
            flightDTO.setAvailableSeat(flight.getAvailableSeat());
            flightDTO.setFlightDataAndTimeDeparture(flight.getFlightDataAndTimeDeparture());
            flightDTO.setFlightDataAndTimeArriving(flight.getFlightDataAndTimeArriving());
            AirportDTO airportDTO = new AirportDTO();
            airportDTO.setName(flight.getAirport().getName());
            airportDTO.setName(flight.getAirport().getName());
            flightDTOList.add(flightDTO);
        }
        return flightDTOList;
    }


    public FlightDTO findFlightByFlightNumber(String numberFlight) {
        Flight flightFound = flightDAO.findFlightByFlightNumber(numberFlight);
        FlightDTO flightDTO = new FlightDTO();
        if (flightFound == null) {
            return null;
        }
        flightDTO.setFlightNumber(flightFound.getFlightNumber());
        flightDTO.setAvailableSeat(flightFound.getAvailableSeat());
        flightDTO.setPrice(flightFound.getPrice());
        flightDTO.setFlightDataAndTimeArriving(flightFound.getFlightDataAndTimeArriving());
        flightDTO.setFlightDataAndTimeDeparture(flightFound.getFlightDataAndTimeDeparture());
        return flightDTO;
    }


}
