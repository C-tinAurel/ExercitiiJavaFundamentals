package frontend;

import business.dto.AirportDTO;
import business.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class AirportController {

    @Autowired
    AirportService airportService;

    @PostMapping(path = "/insertAirport")
    public ResponseEntity insertAirport(@RequestBody @Valid AirportDTO airportDTO) {
        if (airportService.findAirportByName(airportDTO.getName()) == null) {
            airportService.insertAirport(airportDTO);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Aerportul " + airportDTO.getName() + " exista in baza de date");
    }

    @GetMapping(path = "/findAirportByName")
    public String findAirportByName(@RequestParam String name) {
        AirportDTO airportFind = airportService.findAirportByName(name);
        if (airportFind == null) {
            return "Nu a fost gasit Aeroportul " + name;
        }
        return "Aeroportul: " + airportFind + " exista in baza de date";
    }

    @GetMapping(path = "/findAirportByCity")
    public String findAirportByCity(@RequestParam String cityName) {
        List<AirportDTO> airportDTOList = airportService.findAirportByCity(cityName);
        if (airportDTOList == null) {
            return "Nu s-au gasit aeroporturile in Orasul " + cityName;
        }
        return "Aeroporturile gasit in Orasul " + cityName + " sunt " + airportDTOList;
    }


    @PutMapping(path = "/updateAirport")
    public String updateAirport(@RequestParam String newName, @RequestParam String name) {
        Integer updatedRow = airportService.updateAirportName(newName, name);
        if (updatedRow > 0) {
            return "Numele Aeroportului " + name + " a fost actualizat cu succes ";
        } else {
            return "Numele Aerportului " + name + " nu  s-a actualizat";
        }
    }
}

