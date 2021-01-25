package frontend;

import business.dto.TripDTO;
import business.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
public class TripController {
    @Autowired
    TripService tripService;

    @PostMapping(path = "/insertTrip")
    public String insertTrip(@RequestBody @Valid TripDTO tripDTO) {
        tripService.insertTrip(tripDTO);
        return "Ati introdus Calatoria " + tripDTO + " cu succes";
    }

    @GetMapping(path = "/findTripByName")
    public String findTripByName(@RequestParam String name) {
        TripDTO tripDTO = tripService.findTripByName(name);
        if (tripDTO == null) {
            return "Nu a fost introdusa Calatoria cu acest nume";
        }
        return "Calatoria: " + tripDTO;
    }

    @GetMapping(path = "/findAllTrips")
    public String findAllTrips() {
        if (tripService.findAllTrip() == null) {
            return "Nu a fost gasite Calatorii";
        }
        return "Calatorile gasite sunt : " + tripService.findAllTrip();
    }

    @GetMapping(path = "/findTripsByPromoted")
    public String findTripByPromoted(@RequestParam boolean promoted) {
        List<TripDTO> tripPromoted = tripService.findTripPromoted(promoted);
        if (tripPromoted == null) {
            return "Nu au fost gasite Calatorii cu promotie";
        }
        return "Calatoriile cu promotie sunt " + tripPromoted;
    }

    @GetMapping(path = "/findTripByCity")
    public String findTripByCity(@RequestParam String cityName) {
        List<TripDTO> tripDTOList = tripService.findTripByCity(cityName);
        if (tripDTOList == null) {
            return "Nu s-au gasit calatorii dupa orasul " + tripDTOList;
        }
        return "Calatoriile sunt " + tripDTOList;
    }

    @GetMapping(path = "/findTripByCountry")
    public String findTripByCountry(@RequestParam String countryName) {
        List<TripDTO> tripDTOList = tripService.findTripByCountry(countryName);
        if (tripDTOList == null) {
            return "Nu au fost gasite calatorii";
        }
        return "Calatoriile sunt " + tripDTOList;
    }

    @GetMapping(path = "/findTripByContinent")
    public String findTripByContinent(@RequestParam String continentName) {
        List<TripDTO> tripDTOList = tripService.findTripByContinent(continentName);
        if (tripDTOList == null) {
            return "Nu au fost gasite calatorii";
        }
        return "Calatoriile sunt " + tripDTOList;
    }

    @GetMapping(path = "/findTripsRecently")
    public String findTripsRecently(@RequestParam Date departureDate) {
        List<TripDTO> tripDTOList = tripService.findTripsRecently(departureDate);
        if (tripDTOList == null) {
            return "Nu au fost gasite calatorii";
        }
        return "Calatoriile sunt" + tripDTOList;
    }

    @PutMapping(path = "/updateTripByStock")
    public String updateTripByStock(@RequestParam int availableStock, @RequestParam String name) {
        Integer updateRow = tripService.updateTripAvailableStock(availableStock, name);
        if (updateRow > 0) {
            return "Calatoria a fost actualizata cu succes";
        }
        return "Calatoria nu a putut fi actualizata";
    }

    @DeleteMapping(path = "/deleteTripByName")
    public String deleteTripByName(@RequestParam String name) {
        Integer updateRow = tripService.deleteTripByName(name);
        if (updateRow > 0) {
            return "Calatoria a fost stearsa cu succes";
        }
        return "Calatoria nu a fost stearsa";
    }
}

