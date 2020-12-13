package frontend;

import business.dto.ClientDTO;
import business.service.ClientService;
import business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    UserService userService;

    @PostMapping(path = "/insertClient")
    public String insertClient(@RequestBody @Valid ClientDTO clientDTO) {
        clientService.insertClient(clientDTO);
        return "Ati introdus clientul " + clientDTO.getName() + " " + clientDTO.getSurname();
    }


    @GetMapping(path = "/findClient")
    public String findClient(@RequestParam String name, @RequestParam String surname) {
        ClientDTO clientDTO = clientService.findClient(name, surname);
        if (clientDTO == null) {
            return "Clientul " + name + " " + surname + " nu a fost gasit";
        }
        return "Clientul " + clientDTO + " exista in baza de date";
    }


    @GetMapping(path = "/findClientByUser")
    public String findClientByUser(@RequestParam String userName, @RequestParam String password) {
        ClientDTO clientDTO = clientService.findClientByUser(userName, password);
        if (clientDTO == null) {
            return "Nu s-a gasit user-ul " + userName;
        }
        return userName + " exista in baza de date";
    }

    @PutMapping(path = "/updateLogOut")
    public String updateLogOut(@RequestParam String userName){
        Integer result=userService.updateLogIn(false,userName);
        if (result==0){
            return "Nu s-a gasit user-ul " +userName;
        }
        return "User-ul a fost deconectat " +userName;
    }

    /*@PutMapping(path = "/updateLogIn")
    public String updateLogIn(@RequestParam String userName,@RequestParam String password){

    }*/


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
