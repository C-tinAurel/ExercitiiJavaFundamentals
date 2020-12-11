package business.service;

import business.dto.HotelDTO;
import business.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.HotelDAO;
import persistence.dao.RoomDAO;
import persistence.entities.City;
import persistence.entities.Hotel;
import persistence.entities.Room;

import java.util.HashSet;
import java.util.Set;


@Service
public class RoomService {
    @Autowired
    RoomDAO roomDAO;
    @Autowired
    HotelDAO hotelDAO;

    public void insertRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setType(roomDTO.getType());
        room.setExtraBed(roomDTO.isExtraBed());
        room.setNumberAvailable(roomDTO.getNumberAvailable());
        roomDAO.insertRoom(room);
    }


    public Integer updateRoomNumberAvailable(int numberAvailable,String type){
        Integer updatedRow=roomDAO.updateRoomNumberAvailable(numberAvailable, type);
        return updatedRow;
    }
}
