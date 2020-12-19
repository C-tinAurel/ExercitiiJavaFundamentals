package business.service;

import business.dto.AirportDTO;
import business.dto.FlightDTO;
import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.AirportDAO;
import persistence.dao.CityDAO;
import persistence.dao.CountryDAO;
import persistence.dao.FlightDAO;
import persistence.entities.Airport;
import persistence.entities.City;
import persistence.entities.Country;
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
    @Autowired
    CountryDAO countryDAO;


    public void insertFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setAvailableSeat(flightDTO.getAvailableSeat());
        flight.setPrice(flightDTO.getPrice());
        flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
        flight.setFlightDataAndTimeDeparture(flightDTO.getFlightDataAndTimeDeparture());
        setAirportDeparture(flightDTO, flight);
        setAirportArriving(flightDTO, flight);
        flightDAO.insertFlight(flight);
    }

    public void setAirportArriving(FlightDTO flightDTO, Flight flight) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Airport airportArrivingFound = airportDAO.findAirportByName(flightDTO.getAirportDTOArriving().getName());
        if (airportArrivingFound == null) {
            Airport airportArriving = new Airport();
            airportArriving.setName(flightDTO.getAirportDTOArriving().getName());
            session.saveOrUpdate(airportArriving);
            session.getTransaction().commit();
            session.close();
            flight.setAirportArriving(airportArriving);
        } else {
            flight.setAirportArriving(airportArrivingFound);
        }

    }

    public void setAirportDeparture(FlightDTO flightDTO, Flight flight) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Airport airportDepartureFound = airportDAO.findAirportByName(flightDTO.getAirportDTOArriving().getName());
        if (airportDepartureFound == null) {
            Airport airportDeparture = new Airport();
            airportDeparture.setName(flightDTO.getAirportDTODeparture().getName());
            session.saveOrUpdate(airportDeparture);
            session.getTransaction().commit();
            session.close();
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
        flightDTO.setFlightNumber(flightFound.getFlightNumber());
        flightDTO.setAvailableSeat(flightFound.getAvailableSeat());
        flightDTO.setPrice(flightFound.getPrice());
        flightDTO.setFlightDataAndTimeArriving(flightFound.getFlightDataAndTimeArriving());
        flightDTO.setFlightDataAndTimeDeparture(flightFound.getFlightDataAndTimeDeparture());
      /* AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(flightFound.getAirportArriving().getName());
        airportDTO.setName(flightFound.getAirportDeparture().getName());
        flightDTO.setAirportDTOArriving(airportDTO);
        flightDTO.setAirportDTODeparture(airportDTO);*/
        return flightDTO;
    }


}
