package frontend;

import business.dto.UserDTO;
import business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/insertUser")
    public String insertUser(@RequestBody @Valid UserDTO userDTO) {
        if (userService.findUserByName(userDTO.getUserName()) == null) {
            userService.insertUser(userDTO);
            return "Ati introdus User-ul cu succes";
        }
        return "Nu a fost introdus user-ul";
    }

    @GetMapping(path = "/findUserByName")
    public String findUserByName(@RequestParam String userName) {
        UserDTO userDTO = userService.findUserByName(userName);
        if (userDTO == null) {
            return "Nu s-a gasit user-ul " + userName;
        }
        return "User-ul " + userName + " exista in baza de date";
    }

    @PutMapping(path = "/updateUserName")
    public String updateUserName(String userName,String email){
        Integer updateRow=userService.updateUserName(userName, email);
        if (updateRow>0){
            return "User-ul a fost actualizat cu succes";
        }
        return "Nu a fost actualizat User-ul";
    }

    @DeleteMapping(path = "/deleteUser")
    public String deleteUser(String userName ){
        Integer updateRow=userService.deleteUser(userName);
        if(updateRow>0){
            return "User-ul a fost sters";
        }
        return "User-ul nu a fost sters";
    }
}
