package frontend;

import business.dto.RoomDTO;
import business.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;


    @PostMapping(path = "/insertRoom")
    public String insertRoom(@RequestBody @Valid RoomDTO roomDTO){
        roomService.insertRoom(roomDTO);
        return "Ati introdus Camera cu succes "+roomDTO;
    }

    @PutMapping(path = "/updateRoom")
    public String updateRoom(@RequestParam int numberAvailable,@RequestParam String type){
        Integer updatedRow=roomService.updateRoomNumberAvailable(numberAvailable, type);
        if(updatedRow>0){
            return "Ati actualizat cu succes Camera ";
        }
        return "Actualizarea nu s-a putut realiza";
    }
}
