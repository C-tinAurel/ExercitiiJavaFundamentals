package frontend;

import business.dto.ClientDTO;
import business.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(path = "/insertClient")
    public ResponseEntity insertClient(@RequestBody @Valid ClientDTO clientDTO) {
        if (clientService.findClient(clientDTO.getName(), clientDTO.getSurname()) == null) {
            clientService.insertClient(clientDTO);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Clientul " + clientDTO + " exista in baza de date");
    }

    @GetMapping(path = "/findClient")
    public String findClient(@RequestParam String name, @RequestParam String surname) {
        ClientDTO clientDTO = clientService.findClient(name, surname);
        if (clientDTO == null) {
            return "Clientul " + name + " " + surname + " nu a fost gasit";
        }
        return "Clientul " + clientDTO + " exista in baza de date";
    }

    @PutMapping(path = "/updateClientAddress")
    public String updateClientAddress(@RequestParam String address, @RequestParam String name, @RequestParam String surname) {
        Integer updatedRow = clientService.updateClientAddress(address, name, surname);
        if (updatedRow > 0) {
            return "Clientul a fost actualizat cu succes";
        }
        return "Clientul nu a putut fi actualizat";
    }

    @PutMapping(path = "/updateClientPhone")
    public String updateClientPhone(@RequestParam int phoneNumber, @RequestParam String name, @RequestParam String surname) {
        Integer updatedRow = clientService.updateClientPhone(phoneNumber, name, surname);
        if (updatedRow > 0) {
            return "Clientul a fost actualizat cu succes";
        }
        return "Clientul nu a putut fi actualizat";
    }

    @DeleteMapping(path = "/deleteClient")
    public String deleteClient(@RequestParam String name, @RequestParam String surname) {
        Integer updatedRow = clientService.deleteClient(name, surname);
        if (updatedRow > 0) {
            return "Clientul a fost actualizat cu succes";
        }
        return "Clientul nu a putut fi actualizat";
    }


}
