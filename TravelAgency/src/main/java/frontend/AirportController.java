package frontend;

import business.dto.AirportDTO;
import business.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class AirportController {

    @Autowired
    AirportService airportService;

    @PostMapping(path = "/insertAirport")
    public String insertAirport(@RequestBody @Valid AirportDTO airportDTO) {
        airportService.insertAirport(airportDTO);
        return "Ati introdus Aeroportul : " + airportDTO.getName();
    }

    @GetMapping(path = "/findAirportByName")
    public AirportDTO findAirportByName(@RequestParam String name) {
        AirportDTO airportFind = airportService.findAirportByName(name);
        return airportFind;
    }

    @GetMapping(path = "/findAirportByCity")
    public List<AirportDTO> findAirportByCity(@RequestParam String cityName) {
        List<AirportDTO> airportDTOList = airportService.findAirportByCity(cityName);
        return airportDTOList;
    }

    @PutMapping(path = "/updateAirport")
    public String updateAirport(@RequestParam String newName,@RequestParam String name){
       Integer updatedRow=airportService.updateAirportName(newName,name);
        if(updatedRow>0){
            return "Numele Aeroportului a fost actualizat cu succes " ;
        }
        return "Numele Aerportului nu  s-a actualizat";
        }
    }

