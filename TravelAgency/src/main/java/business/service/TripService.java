package business.service;

import business.dto.*;
import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import java.sql.Date;
import java.util.ArrayList;
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
    @Autowired
    ContinentDAO continentDAO;
    @Autowired
    CountryDAO countryDAO;
    @Autowired
    CityDAO cityDAO;


    public void insertTrip(TripDTO tripDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
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
        setAirportDeparture(tripDTO, trip);
        setAirportArriving(tripDTO, trip);
        tripDAO.insertTrip(trip);
        session.saveOrUpdate(trip);
        session.getTransaction().commit();
        session.close();
    }

    public void setHotel(Trip trip, TripDTO tripDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Continent continentHotel = null;
        continentHotel = continentDAO.findContinent(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName(), session);
        if (continentHotel == null) {
            continentHotel = new Continent();
            continentHotel.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            session.saveOrUpdate(continentHotel);
        }
        Country countryHotel = null;
        countryHotel = countryDAO.findCountry(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getName(), session);
        if (countryHotel == null) {
            countryHotel = new Country();
            countryHotel.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getName());
            countryHotel.setContinent(continentHotel);
        }
        City cityHotel = null;
        cityHotel = cityDAO.findCity(tripDTO.getHotelDTO().getCityDTO().getName(), session);
        if (cityHotel == null) {
            cityHotel = new City();
            cityHotel.setName(tripDTO.getHotelDTO().getCityDTO().getName());
            cityHotel.setCountry(countryHotel);
        }
        Hotel hotel = null;
        hotel = hotelDAO.findHotelByName(tripDTO.getHotelDTO().getName(), session);
        if (hotel == null) {
            hotel = new Hotel();
            hotel.setName(tripDTO.getHotelDTO().getName());
            hotel.setDescription(tripDTO.getHotelDTO().getDescription());
            hotel.setStars(tripDTO.getHotelDTO().getStars());
            hotel.setAddress(tripDTO.getHotelDTO().getAddress());
            hotel.setCity(cityHotel);
            setRoom(tripDTO, hotel);
        }
        trip.setHotel(hotel);
        session.getTransaction().commit();
        session.close();
    }

    public void setRoom(TripDTO tripDTO, Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for (RoomDTO roomDTO : tripDTO.getHotelDTO().getRoomDTOSet()) {
            Room room = new Room();
            room.setType(roomDTO.getType());
            room.setNumberAvailable(roomDTO.getNumberAvailable());
            room.setExtraBed(roomDTO.isExtraBed());
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }


    public void setAirportDeparture(TripDTO tripDTO, Trip trip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Continent continentAirportDeparture = new Continent();
        if (!tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName().equalsIgnoreCase(continentAirportDeparture.getName())) {
            continentAirportDeparture = continentDAO.findContinent(tripDTO.getAirportDepartureDTO().getCityDTO().getCountryDTO().getContinentDTO().getName(), session);
            if (continentAirportDeparture == null) {
                continentAirportDeparture = new Continent();
                continentAirportDeparture.setName(tripDTO.getAirportDepartureDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
            }
        }
        Country countryAirportDeparture = null;
        countryAirportDeparture = countryDAO.findCountry(tripDTO.getAirportDepartureDTO().getCityDTO().getCountryDTO().getName(), session);
        if (countryAirportDeparture == null) {
            countryAirportDeparture = new Country();
            countryAirportDeparture.setName(tripDTO.getAirportDepartureDTO().getCityDTO().getCountryDTO().getName());
            if (continentAirportDeparture == null) {
                countryAirportDeparture.setContinent(continentAirportDeparture);
            } else {
                countryAirportDeparture.setContinent(trip.getHotel().getCity().getCountry().getContinent());
            }
        }
        City cityAirportDeparture = null;
        cityAirportDeparture = cityDAO.findCity(tripDTO.getAirportDepartureDTO().getCityDTO().getName(), session);
        if (cityAirportDeparture == null) {
            cityAirportDeparture = new City();
            cityAirportDeparture.setName(tripDTO.getAirportDepartureDTO().getCityDTO().getName());
            cityAirportDeparture.setCountry(countryAirportDeparture);
        }
        Airport airportDeparture = null;
        airportDeparture = airportDAO.findAirportByName(tripDTO.getAirportDepartureDTO().getName(), session);
        if (airportDeparture == null) {
            airportDeparture = new Airport();
            airportDeparture.setName(tripDTO.getAirportDepartureDTO().getName());
            airportDeparture.setCity(cityAirportDeparture);
        }
        //   setFlightArriving(tripDTO,airportDeparture);
        trip.setAirportDeparture(airportDeparture);
        session.getTransaction().commit();
        session.close();
    }

    public void setFlightDeparture(TripDTO tripDTO, Airport airportDeparture) {
        Set<Flight> flightSet = new HashSet<>();
        for (FlightDTO flightDTO : tripDTO.getAirportDepartureDTO().getFlightDTODepartureSet()) {
            Flight flight = new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setFlightDataAndTimeDeparture(flightDTO.getFlightDataAndTimeDeparture());
            flight.setAvailableSeat(flightDTO.getAvailableSeat());
            flight.setPrice(flightDTO.getPrice());
            flightSet.add(flight);
        }
        airportDeparture.setFlightDepartureSet(flightSet);
    }


    public void setAirportArriving(TripDTO tripDTO, Trip trip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Continent continentAirportArriving = null;
        continentAirportArriving = continentDAO.findContinent(tripDTO.getAirportArrivingDTO().getCityDTO().getCountryDTO().getContinentDTO().getName(), session);
        if (continentAirportArriving == null) {
            continentAirportArriving = new Continent();
            continentAirportArriving.setName(tripDTO.getAirportArrivingDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        }
        Country countryAirportArriving = null;
        countryAirportArriving = countryDAO.findCountry(tripDTO.getAirportArrivingDTO().getCityDTO().getCountryDTO().getName(), session);
        if (countryAirportArriving == null) {
            countryAirportArriving = new Country();
            countryAirportArriving.setName(tripDTO.getAirportArrivingDTO().getCityDTO().getCountryDTO().getName());
            countryAirportArriving.setContinent(continentAirportArriving);
        }
        City cityAirportArriving = null;
        cityAirportArriving = cityDAO.findCity(tripDTO.getAirportArrivingDTO().getCityDTO().getName(), session);
        if (cityAirportArriving == null) {
            cityAirportArriving = new City();
            cityAirportArriving.setName(tripDTO.getAirportArrivingDTO().getCityDTO().getName());
            cityAirportArriving.setCountry(countryAirportArriving);
        }
        Airport airportArriving = null;
        airportArriving = airportDAO.findAirportByName(tripDTO.getAirportArrivingDTO().getName(), session);
        if (airportArriving == null) {
            airportArriving = new Airport();
            airportArriving.setName(tripDTO.getAirportArrivingDTO().getName());
            airportArriving.setCity(cityAirportArriving);
            //setFlightArriving(tripDTO,airportArriving);
        }
        trip.setAirportArriving(airportArriving);
        session.getTransaction().commit();
        session.close();
    }

    public void setFlightArriving(TripDTO tripDTO, Airport airportArriving) {
        Set<Flight> flightSet = new HashSet<>();
        for (FlightDTO flightDTO : tripDTO.getAirportArrivingDTO().getFlightDTOArrivingSet()) {
            Flight flight = new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
            flight.setPrice(flightDTO.getPrice());
            flight.setAvailableSeat(flightDTO.getAvailableSeat());
            flightSet.add(flight);
        }
        airportArriving.setFlightDepartureSet(flightSet);
    }


    public TripDTO findTripByName(String name) {
        Trip trip = tripDAO.findTripByName(name);
        if (trip == null) {
            return null;
        }
        TripDTO tripDTO = new TripDTO();
        tripDTO.setName(trip.getName());
        tripDTO.setCheckIn(trip.getCheckIn());
        tripDTO.setCheckOut(trip.getCheckOut());
        tripDTO.setDepartureDate(trip.getDepartureDate());
        tripDTO.setReturnData(trip.getReturnData());
        tripDTO.setNumberDay(trip.getNumberDay());
        tripDTO.setMealType(trip.getMealType());
        tripDTO.setAdultPrice(trip.getAdultPrice());
        tripDTO.setKidPrice(trip.getKidPrice());
        tripDTO.setPromoted(trip.isPromoted());
        tripDTO.setAdultNumber(trip.getAdultNumber());
        tripDTO.setKidNumber(trip.getKidNumber());
        tripDTO.setAvailableStock(trip.getAvailableStock());
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(trip.getHotel().getName());
        tripDTO.setHotelDTO(hotelDTO);
        return tripDTO;
    }

    public List<TripDTO> findAllTrip() {
        List<Trip> tripList = tripDAO.findAllTrips();
        if (tripList == null) {
            return null;
        }
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(trip.getHotel().getName());
            tripDTO.setHotelDTO(hotelDTO);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripPromoted(boolean promoted) {
        List<Trip> tripList = tripDAO.findTriPromoted(promoted);
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }


    public List<TripDTO> findTripByCity(String cityName) {
        List<Trip> tripList = tripDAO.findTripByCity(cityName);
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(trip.getHotel().getName());
            tripDTO.setHotelDTO(hotelDTO);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(trip.getHotel().getCity().getName());
            hotelDTO.setCityDTO(cityDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }


    public List<TripDTO> findTripByCountry(String countryName) {
        List<Trip> tripList = tripDAO.findTripByCountry(countryName);
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(trip.getHotel().getName());
            tripDTO.setHotelDTO(hotelDTO);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(trip.getHotel().getCity().getName());
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(trip.getHotel().getCity().getCountry().getName());
            cityDTO.setCountryDTO(countryDTO);
            hotelDTO.setCityDTO(cityDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }


    public List<TripDTO> findTripByContinent(String continentName) {
        List<Trip> tripList = tripDAO.findTripByContinent(continentName);
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            ContinentDTO continentDTO = new ContinentDTO();
            continentDTO.setName(trip.getHotel().getCity().getCountry().getContinent().getName());
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(trip.getHotel().getCity().getCountry().getName());
            countryDTO.setContinentDTO(continentDTO);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(trip.getHotel().getCity().getName());
            cityDTO.setCountryDTO(countryDTO);
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(trip.getHotel().getName());
            hotelDTO.setCityDTO(cityDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }

    public List<TripDTO> findTripsRecently(Date departureDate) {
        List<Trip> tripList = tripDAO.findTripRecently(departureDate);
        List<TripDTO> tripDTOList = new ArrayList<>();
        for (Trip trip : tripList) {
            TripDTO tripDTO = new TripDTO();
            tripDTO.setName(trip.getName());
            tripDTO.setCheckIn(trip.getCheckIn());
            tripDTO.setCheckOut(trip.getCheckOut());
            tripDTO.setDepartureDate(trip.getDepartureDate());
            tripDTO.setReturnData(trip.getReturnData());
            tripDTO.setNumberDay(trip.getNumberDay());
            tripDTO.setMealType(trip.getMealType());
            tripDTO.setAdultPrice(trip.getAdultPrice());
            tripDTO.setKidPrice(trip.getKidPrice());
            tripDTO.setPromoted(trip.isPromoted());
            tripDTO.setAdultNumber(trip.getAdultNumber());
            tripDTO.setKidNumber(trip.getKidNumber());
            tripDTO.setAvailableStock(trip.getAvailableStock());
            ContinentDTO continentDTO = new ContinentDTO();
            continentDTO.setName(trip.getHotel().getCity().getCountry().getContinent().getName());
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(trip.getHotel().getCity().getCountry().getName());
            countryDTO.setContinentDTO(continentDTO);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(trip.getHotel().getCity().getName());
            cityDTO.setCountryDTO(countryDTO);
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(trip.getHotel().getName());
            hotelDTO.setCityDTO(cityDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTO.setHotelDTO(hotelDTO);
            tripDTOList.add(tripDTO);
        }
        return tripDTOList;
    }


    public Integer updateTripAvailableStock(int availableStock,String name){
        Integer updateRow=tripDAO.updateTripAvailableStock(availableStock, name);
        return updateRow;
    }

    public Integer deleteTripByName(String name){
        Integer updatedRow=tripDAO.deleteTripByName(name);
        return updatedRow;
    }
}
