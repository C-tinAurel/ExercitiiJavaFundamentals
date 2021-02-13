package frontend;

import business.dto.UserRegistrationDTO;
import business.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserRegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping(path = "/insertUser")
    public String insert(@RequestBody @Valid UserRegistrationDTO insertUser) {
       userRegistrationService.insertUser(insertUser);
        return "Ati inserat User-ul " + insertUser.getName() + " " + insertUser.getSurname();
    }

    @GetMapping(path = "/findUser")
    public List<UserRegistrationDTO> findUserByName(@RequestParam String name) {
        List<UserRegistrationDTO> userRegistrationDTOList = userRegistrationService.findUserByName(name);
        return userRegistrationDTOList;
    }

    @DeleteMapping(path = "/deleteUser")
    public String deleteUserByEmail(@RequestParam String email) {
        Integer numberOfDeletedUser = userRegistrationService.deleteUserByEmail(email);
        if (numberOfDeletedUser > 0) {
            return "Am sters cu succes user-ul";
        } else {
            return "Stergere user-ului nu se poate efectua";
        }
    }

    @PutMapping(path = "/updateUser")
    public String updateUserBySurname(@RequestParam String surname, @RequestParam String name) {
        Integer numberOfUpdatedUserSurname = userRegistrationService.updateUserBySurname(surname, name);
        if (numberOfUpdatedUserSurname > 0) {
            return "Ati actualizat cu succes user-ul";
        } else {
            return "Nu ati actualizat user-ul";
        }
    }
}
