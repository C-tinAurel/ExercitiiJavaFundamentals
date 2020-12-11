package frontend;

import business.dto.HotelDTO;
import business.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping(path = "/insertHotel")
    public ResponseEntity insertHotel(@RequestBody @Valid HotelDTO hotelDTO) {
       if(hotelService.findHotelByName(hotelDTO.getName())==null){
           hotelService.insertHotel(hotelDTO);
       }
       return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Hotelul " +hotelDTO.getName() + " exista in baza de date");
    }

    @GetMapping(path = "/findHotelByName")
    public HotelDTO findHotelByName(@RequestParam String name) {
        HotelDTO findHotel = hotelService.findHotelByName(name);
        return findHotel;
    }

    @GetMapping(path = "/findHotelByCity")
    public List<HotelDTO> findHotelByCity(@RequestParam String cityName) {
        List<HotelDTO> hotelDTOList = hotelService.findHotelByCity(cityName);
        return hotelDTOList;
    }

    @GetMapping(path = "/findHotelByTypeAndRoomAvailable")
    public List<HotelDTO> findHotelByAvailableRoomAndType(@RequestParam String roomAvailable, @RequestParam String type) {
        List<HotelDTO> hotelDTOList = hotelService.findHotelByAvailableRoomAndType(roomAvailable, type);
        return hotelDTOList;
    }

    @GetMapping(path = "/findHotelByExtraBed")
    public List<HotelDTO> findHotelWithExtraBed(boolean extraBed) {
        List<HotelDTO> hotelDTOList = hotelService.findHotelWithExtraBed(extraBed);
        return hotelDTOList;
    }

    @PutMapping(path = "/updateHotelStar")
    public String updateHotelStars(@RequestParam int stars, @RequestParam String name) {
        Integer updateRow = hotelService.updateHotelStars(stars, name);
        if (updateRow > 0) {
            return "Actualizarea a fost efectuata";
        } else {
            return "Nu am putut efectua actualizarea";
        }
    }

    @PutMapping(path = "/updateHotelName")
    public String updateHotelName(@RequestParam String name, @RequestParam String newName) {
        Integer updatedRow = hotelService.updateHotelName(name, newName);
        if (updatedRow > 0) {
            return "Actualizarea a fost efectuata";
        } else {
            return "Nu am putut efectua actualizarea";
        }
    }

    @DeleteMapping(path = "/deleteHotel")
    public String deleteHotel(@RequestParam String name) {
        Integer updatedRow = hotelService.deleteHotel(name);
        if (updatedRow > 0) {
            return "Hotelul a fost sters";
        } else {
            return "Hotelul nu a fost sters";
        }
    }
}
