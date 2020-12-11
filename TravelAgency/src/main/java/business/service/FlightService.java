package business.service;

import business.dto.AirportDTO;
import business.dto.FlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.dao.CityDAO;
import persistence.dao.FlightDAO;
import persistence.entities.Airport;
import persistence.entities.City;
import persistence.entities.Flight;

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

    public void insertFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setAvailableSeat(flightDTO.getAvailableSeat());
        flight.setPrice(flightDTO.getPrice());
        flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
        setAirportArriving(flight, flightDTO);
        flight.setFlightDataAndTimeDeparture(flightDTO.getFlightDataAndTimeDeparture());
        setAirportDeparture(flight, flightDTO);
        flightDAO.insertFlight(flight);
    }


    public void setAirportArriving(Flight flight, FlightDTO flightDTO) {
        Airport airportArrivingFound = airportDAO.findAirportByName(flightDTO.getAirportDTOArriving().getName());
        City cityFound = cityDAO.findCity(flightDTO.getAirportDTOArriving().getCityDTO().getCountryDTO().getContinentDTO().getName());
        if (airportArrivingFound == null) {
            Airport airportArriving = new Airport();
            airportArriving.setName(flightDTO.getAirportDTOArriving().getName());
            airportArriving.setCity(cityFound);
            flight.setAirportArriving(airportArriving);
        } else {
            flight.setAirportArriving(airportArrivingFound);
        }
    }


    public void setAirportDeparture(Flight flight, FlightDTO flightDTO) {
        Airport airportDepartureFound = airportDAO.findAirportByName(flightDTO.getAirportDTODeparture().getName());
         City cityFound = cityDAO.findCity(flightDTO.getAirportDTODeparture().getCityDTO().getCountryDTO().getContinentDTO().getName());
        Airport airportDeparture = new Airport();
        if (airportDepartureFound == null) {
            airportDeparture.setName(flightDTO.getAirportDTODeparture().getName());
          airportDeparture.setCity(cityFound);
            flight.setAirportDeparture(airportDeparture);
        } else {
            flight.setAirportDeparture(airportDepartureFound);
        }
    }


    public List<FlightDTO> findFlightByAirportDeparture(String airportName) {
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
            airportDTO.setName(flight.getAirportDeparture().getName());
            airportDTO.setName(flight.getAirportArriving().getName());
            flightDTO.setAirportDTODeparture(airportDTO);
            flightDTO.setAirportDTOArriving(airportDTO);
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
        Flight flight = new Flight();
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setAvailableSeat(flight.getAvailableSeat());
        flightDTO.setPrice(flight.getPrice());
        flightDTO.setFlightDataAndTimeArriving(flight.getFlightDataAndTimeArriving());
        flightDTO.setFlightDataAndTimeDeparture(flight.getFlightDataAndTimeDeparture());
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(flight.getAirportArriving().getName());
        airportDTO.setName(flight.getAirportDeparture().getName());
        flightDTO.setAirportDTOArriving(airportDTO);
        flightDTO.setAirportDTODeparture(airportDTO);
        return flightDTO;
    }

}
