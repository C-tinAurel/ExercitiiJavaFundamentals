package business.service;

import business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TripService {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    AirportDAO airportDAO;
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    FlightDAO flightDAO;


    //inseram la trip inca
    public void insertTrip(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setName(tripDTO.getName());
        trip.setCheckIn(tripDTO.getCheckIn());
        trip.setCheckOut(tripDTO.getCheckOut());
        trip.setDepartureDate(tripDTO.getDepartureDate());
        trip.setReturnData(tripDTO.getReturnData());
        trip.setNumberDay(tripDTO.getNumberDay());
        trip.setMealType(tripDTO.getMealType());
        trip.setAdultPrice(tripDTO.getAdultPrice());
        trip.setKidPrice(tripDTO.getKidPrice());
        trip.setPromoted(tripDTO.isPromoted());
        trip.setAdultNumber(tripDTO.getAdultNumber());
        trip.setKidNumber(tripDTO.getKidNumber());
        trip.setAvailableStock(tripDTO.getAvailableStock());
        setHotel(trip, tripDTO);
        setAirportDeparture(tripDTO,trip);
        setAirportArriving(tripDTO,trip);
        tripDAO.insertTrip(trip);

    }

    public void setHotel(Trip trip, TripDTO tripDTO) {
        Hotel hotelFound = hotelDAO.findHotelByName(tripDTO.getHotelDTO().getName());
        if (hotelFound == null) {
            Hotel hotel = new Hotel();
            hotel.setName(tripDTO.getHotelDTO().getName());
            hotel.setDescription(tripDTO.getHotelDTO().getDescription());
            hotel.setAddress(tripDTO.getHotelDTO().getAddress());
            hotel.setStars(tripDTO.getHotelDTO().getStars());
            Continent continent = new Continent();
            continent.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            Country country = new Country();
            country.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getName());
            country.setContinent(continent);
            City city = new City();
            city.setName(tripDTO.getHotelDTO().getCityDTO().getName());
            city.setCountry(country);
            hotel.setCity(city);
            setRoom(tripDTO,trip.getHotel());
        } else {
            trip.setHotel(hotelFound);
        }
    }

    public void setRoom( TripDTO tripDTO,Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for (RoomDTO roomDTO : tripDTO.getHotelDTO().getRoomDTOSetSet()) {
            Room room = new Room();
            room.setType(roomDTO.getType());
            room.setNumberAvailable(roomDTO.getNumberAvailable());
            room.setExtraBed(roomDTO.isExtraBed());
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }


    public void setAirportDeparture(TripDTO tripDTO, Trip trip){
        Airport airportDepartureFound= airportDAO.findAirportByName(tripDTO.getAirportDTO().getName());
        if(airportDepartureFound==null){
            Airport airportDeparture=new Airport();
            airportDeparture.setName(tripDTO.getAirportDTO().getName());
            Continent continent=new Continent();
            Country country=new Country();
            City city=new City();
            continent.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
            country.setContinent(continent);
            city.setName(tripDTO.getAirportDTO().getCityDTO().getName());
            city.setCountry(country);
            setFlightDeparture(tripDTO,airportDeparture);
            airportDeparture.setCity(city);
        }else {
            trip.setAirport(airportDepartureFound);
        }
    }

    public void setFlightDeparture(TripDTO tripDTO,Airport airportDeparture){
        FlightDTO flightDTO=new FlightDTO();
        Flight flightDepartureFound=flightDAO.findFlightByFlightNumber(flightDTO.getFlightNumber());
        Set<Flight> flightSet=new HashSet<>();
        if(flightDepartureFound==null){
            for(FlightDTO flightDTO1 :tripDTO.getAirportDTO().getFlightDTODepartureSet()){
                Flight flight=new Flight();
            flight.setFlightNumber(flightDTO1.getFlightNumber());
            flight.setFlightDataAndTimeDeparture(flightDTO1.getFlightDataAndTimeDeparture());
            flight.setAvailableSeat(flightDTO1.getAvailableSeat());
            flight.setPrice(flightDTO1.getPrice());
            flightSet.add(flight);
            }
        }else{
            airportDeparture.setFlightDepartureSet(flightSet);
        }
    }

    public void setAirportArriving(TripDTO tripDTO, Trip trip){
        Airport airportArrivingFound= airportDAO.findAirportByName(tripDTO.getAirportDTO().getName());
        if(airportArrivingFound==null){
            Airport airportArriving=new Airport();
            airportArriving.setName(tripDTO.getAirportDTO().getName());
            Continent continent=new Continent();
            Country country=new Country();
            City city=new City();
            continent.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
            country.setContinent(continent);
            city.setName(tripDTO.getAirportDTO().getCityDTO().getName());
            city.setCountry(country);
            airportArriving.setCity(city);
            setFlightArriving(tripDTO,airportArriving);
        }else {
            trip.setAirport(airportArrivingFound);
        }
    }

    public void setFlightArriving(TripDTO tripDTO,Airport airportArriving){
        Set<Flight> flightSet=new HashSet<>();
        for (FlightDTO flightDTO:tripDTO.getAirportDTO().getFlightDTOArrivingSet()){
            Flight flight=new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
            flight.setPrice(flightDTO.getPrice());
            flight.setAvailableSeat(flightDTO.getAvailableSeat());
            flightSet.add(flight);
        }
        airportArriving.setFlightDepartureSet(flightSet);
    }
}
