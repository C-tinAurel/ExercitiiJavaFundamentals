package business.service;

import business.dto.*;
import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.*;
import persistence.entities.*;

import javax.transaction.Transactional;
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
        setHotel(trip, tripDTO, session);
        setAirport(tripDTO, trip, session);
        tripDAO.insertTrip(trip, session);
        session.getTransaction().commit();
        session.close();

    }

    public void setHotel(Trip trip, TripDTO tripDTO, Session session) {
        Continent continentHotel = null;
            continentHotel = continentDAO.findContinent(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName(), session);
            if (continentHotel == null) {
                continentHotel = new Continent();
                continentHotel.setName(tripDTO.getHotelDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
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


    public void setAirport(TripDTO tripDTO, Trip trip, Session session) {
        Continent continent = null;
        continent = continentDAO.findContinent(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName(), session);
        if (continent == null) {
            continent = new Continent();
            continent.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getContinentDTO().getName());
        }
        Country country = null;
        country = countryDAO.findCountry(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName(), session);
        if (country == null) {
            country = new Country();
            country.setName(tripDTO.getAirportDTO().getCityDTO().getCountryDTO().getName());
            country.setContinent(continent);
        }
        City city = null;
        city = cityDAO.findCity(tripDTO.getAirportDTO().getCityDTO().getName(), session);
        if (city == null) {
            city = new City();
            city.setName(tripDTO.getAirportDTO().getCityDTO().getName());
            city.setCountry(country);
        }
        Airport airport = null;
        airport = airportDAO.findAirportByName(tripDTO.getAirportDTO().getName(), session);
        if (airport == null) {
            airport = new Airport();
            airport.setName(tripDTO.getAirportDTO().getName());
            airport.setCity(city);
            setFlight(tripDTO, airport);
        }
        trip.setAirport(airport);

    }


    public void setFlight(TripDTO tripDTO, Airport airport) {
        Set<Flight> flightSet = new HashSet<>();
        for (FlightDTO flightDTO : tripDTO.getAirportDTO().getFlightDTOSet()) {
            Flight flight = new Flight();
            flight.setFlightNumber(flightDTO.getFlightNumber());
            flight.setFlightDataAndTimeArriving(flightDTO.getFlightDataAndTimeArriving());
            flight.setFlightDataAndTimeDeparture(flightDTO.getFlightDataAndTimeDeparture());
            flight.setPrice(flightDTO.getPrice());
            flight.setAvailableSeat(flightDTO.getAvailableSeat());
            flightSet.add(flight);
        }
        airport.setFlightSet(flightSet);
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


    public Integer updateTripAvailableStock(int availableStock, String name) {
        Integer updateRow = tripDAO.updateTripAvailableStock(availableStock, name);
        return updateRow;
    }

    public Integer deleteTripByName(String name) {
        Integer updatedRow = tripDAO.deleteTripByName(name);
        return updatedRow;
    }
}
