package business.service;

import business.dto.CityDTO;
import business.dto.HotelDTO;
import business.dto.RoomDTO;
import business.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.ContinentDAO;
import persistence.dao.CountryDAO;
import persistence.dao.HotelDAO;
import persistence.entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelService {

    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    ContinentDAO continentDAO;
    @Autowired
    CountryDAO countryDAO;


    public void insertHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setStars(hotelDTO.getStars());
        hotel.setAddress(hotelDTO.getAddress());
        setCity(hotelDTO,hotel);
        setRoom(hotelDTO,hotel);
        hotelDAO.insertHotel(hotel);
    }

    public void setRoom(HotelDTO hotelDTO,Hotel hotel) {
        Set<Room> roomSet = new HashSet<>();
        for (RoomDTO roomDTO : hotelDTO.getRoomDTOSet()) {
            Room room = new Room();
            room.setType(roomDTO.getType());
            room.setNumberAvailable(roomDTO.getNumberAvailable());
            room.setExtraBed(roomDTO.isExtraBed());
            roomSet.add(room);
        }
        hotel.setRoomSet(roomSet);
    }

    public void setCity(HotelDTO hotelDTO,Hotel hotel) {
        City cityFound=cityDAO.findCity(hotelDTO.getCityDTO().getName());
        if(cityFound==null){
            City city=new City();
            city.setName(hotelDTO.getCityDTO().getName());
            setCountry(hotelDTO,city);
            hotel.setCity(city);
        }else{
            hotel.setCity(cityFound);
        }
    }


    public void setCountry (HotelDTO hotelDTO,City city){
        Country countryFound=countryDAO.findCountry(hotelDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
        if(countryFound==null){
            Country country=new Country();
            country.setName(hotelDTO.getCityDTO().getCountryDTO().getName());
            setContinent(hotelDTO,country);
            city.setCountry(country);
        }else{
            city.setCountry(countryFound);
        }
    }

    public void setContinent(HotelDTO hotelDTO,Country country){
        Continent continentFound=continentDAO.findContinent(hotelDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
        if(continentFound==null){
            Continent continent=new Continent();
            continent.setName(hotelDTO.getCityDTO().getCountryDTO().getContinentDTO().getName());
            country.setContinent(continent);
        }else{
            country.setContinent(continentFound);
        }
    }

    public HotelDTO findHotelByName(String name) {
        Hotel hotel = hotelDAO.findHotelByName(name);
        if(hotel==null){
            return null;
        }
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotel.getName());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setDescription(hotel.getDescription());
        hotelDTO.setStars(hotel.getStars());
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(hotel.getCity().getName());
        hotelDTO.setCityDTO(cityDTO);
        return hotelDTO;
    }

    public List<HotelDTO> findHotelByCity(String cityName) {
        List<Hotel> hotelList = hotelDAO.findHotelByCity(cityName);
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setStars(hotel.getStars());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(hotel.getCity().getName());
            hotelDTO.setCityDTO(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public List<HotelDTO> findHotelByAvailableRoomAndType(String roomAvailable, String type) {
        List<Hotel> hotelList = hotelDAO.findHotelByAvailableRoomAndType(roomAvailable, type);
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setStars(hotel.getStars());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(hotel.getCity().getName());
            hotelDTO.setCityDTO(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public List<HotelDTO> findHotelWithExtraBed(boolean extraBed) {
        List<Hotel> hotelList = hotelDAO.findHotelWithExtraBed(extraBed);
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setStars(hotel.getStars());
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(hotel.getCity().getName());
            hotelDTO.setCityDTO(cityDTO);
            hotelDTOList.add(hotelDTO);
        }
        return hotelDTOList;
    }

    public Integer updateHotelStars(int stars, String name) {
        Integer updatedRow = hotelDAO.updateHotelStars(stars, name);
        return updatedRow;
    }

    public Integer updateHotelName(String name, String newName) {
        Integer updatedRow = hotelDAO.updateHotelName(name, newName);
        return updatedRow;
    }

    public Integer deleteHotel(String name) {
        Integer updatedRow = hotelDAO.deleteHotel(name);
        return updatedRow;
    }
}