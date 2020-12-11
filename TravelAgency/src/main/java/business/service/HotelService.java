package business.service;

import business.dto.CityDTO;
import business.dto.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.CityDAO;
import persistence.dao.CountryDAO;
import persistence.dao.HotelDAO;
import persistence.entities.City;
import persistence.entities.Continent;
import persistence.entities.Country;
import persistence.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;


    public void insertHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setDescription(hotelDTO.getDescription());
        hotel.setStars(hotelDTO.getStars());
        hotel.setAddress(hotelDTO.getAddress());
        setCity(hotelDTO,hotel);
        hotelDAO.insertHotel(hotel);
    }

    public void setCity(HotelDTO hotelDTO,Hotel hotel) {
        City cityFound=cityDAO.findCity(hotelDTO.getCityDTO().getName());
        if(cityFound==null){
            City city=new City();
            city.setName(hotelDTO.getCityDTO().getName());
            countryService.setContinent(hotel.getCity().getCountry(),hotelDTO.getCityDTO().getCountryDTO());
            cityService.setCountry(hotel.getCity(),hotelDTO.getCityDTO());
            hotel.setCity(city);
        }else{
            hotel.setCity(cityFound);
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