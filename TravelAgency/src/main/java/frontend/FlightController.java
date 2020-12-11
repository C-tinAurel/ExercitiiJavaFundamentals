package frontend;

import business.dto.FlightDTO;
import business.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightController {
   @Autowired
    FlightService flightService;

   @PostMapping(path = "/insertFlight")
   //nu am reusit sa inserez
   public ResponseEntity insertFlight(@RequestBody @Valid FlightDTO flightDTO){
       if(flightService.findFlightByFlightNumber(flightDTO.getFlightNumber())==null){
           flightService.insertFlight(flightDTO);
       }
       return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Zborul " +flightDTO + " exista deja in baza de date");
   }

   @GetMapping(path = "/findFlightNumber")
   public String findFlightByFlightNumber(@RequestParam String numberFlight){
       FlightDTO flightDTO= flightService.findFlightByFlightNumber(numberFlight);
       if(flightDTO==null){
           return "Nu s-a gasit zborul";
       }
       return "Zborul " +flightDTO+ " exista in baza de date";
   }

   @GetMapping(path = "/findFlightByAirportDeparture")
   public String findFlightByDepartureAirportDeparture(@RequestParam String airportName){
       List<FlightDTO> flightDTOList=flightService.findFlightByAirportDeparture(airportName);
       if(flightDTOList==null){
           return "Nu exista zboruri in Aeroportul " +airportName;
       }
       return "Zborul din Aeroportul " +airportName + " sunt " +flightDTOList;
   }
}
