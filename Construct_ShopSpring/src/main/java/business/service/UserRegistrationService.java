package business.service;

import business.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.UserRegistrationDAO;
import persistence.entities.UserRegistration;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationService {
    @Autowired
    UserRegistrationDAO userRegistrationDAO;

    public void insertUser(UserRegistrationDTO userRegistrationDTO) {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setName(userRegistrationDTO.getName());
        userRegistration.setSurname(userRegistrationDTO.getSurname());
        userRegistration.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        userRegistration.setEmail(userRegistrationDTO.getEmail());
        userRegistration.setPassword(userRegistrationDTO.getPassword());
        userRegistration.setOrderNumber(userRegistrationDTO.getOrderNumber());
        userRegistrationDAO.insertUser(userRegistration);
    }

    public List<UserRegistrationDTO> findUserByName(String name) {
        List<UserRegistration> userRegistrationList = userRegistrationDAO.findUserByName(name);
        List<UserRegistrationDTO> userRegistrationDTOList = new ArrayList<>();
        for (UserRegistration userRegistration : userRegistrationList) {
            UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
            userRegistrationDTO.setName(userRegistration.getName());
            userRegistrationDTO.setSurname(userRegistration.getSurname());
            userRegistrationDTO.setPhoneNumber(userRegistration.getPhoneNumber());
            userRegistrationDTO.setEmail(userRegistration.getEmail());
            userRegistrationDTO.setPassword(userRegistration.getPassword());
            userRegistrationDTO.setOrderNumber(userRegistration.getOrderNumber());
            userRegistrationDTOList.add(userRegistrationDTO);
        }
        return userRegistrationDTOList;
    }

    public Integer deleteUserByEmail(String email) {
        Integer numberOfDeletedUserByEmail = userRegistrationDAO.deleteUserByEmail(email);
        return numberOfDeletedUserByEmail;
    }

    public Integer updateUserBySurname(String surname, String name) {
        Integer numberOfUpdatedUserBySurname = userRegistrationDAO.updateUserSurname(surname, name);
        return numberOfUpdatedUserBySurname;
    }
}
