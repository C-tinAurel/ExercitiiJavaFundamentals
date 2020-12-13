package business.service;

import business.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.UserDAO;
import persistence.entities.Client;
import persistence.entities.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void insertUser(UserDTO userDTO){
        User user=new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        cryptPassword(user,userDTO);
        Client client=new Client();
        client.setName(userDTO.getClientDTO().getName());
        client.setSurname(userDTO.getClientDTO().getSurname());
        client.setAddress(userDTO.getClientDTO().getAddress());
        client.setYearOfBirth(userDTO.getClientDTO().getYearOfBirth());
        client.setPhoneNumber(userDTO.getClientDTO().getPhoneNumber());
        user.setClient(client);
        userDAO.insertUser(user);
    }


    public void cryptPassword(User user,UserDTO userDTO){
        MessageDigest messageDigest= null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger= new BigInteger(1,messageDigest.digest(userDTO.getPassword().getBytes()));
        String passwordCrypt=bigInteger.toString();
        user.setPassword(passwordCrypt);

    }

    public UserDTO findUserByName(String userName){
        User user=userDAO.findUserByName(userName);
        if(user==null){
            return null;
        }
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

   /* public User findUserLogIn(String userName,String password){
        MessageDigest messageDigest= null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger= new BigInteger(1,messageDigest.digest(password.getBytes()));
        String passwordCrypt=bigInteger.toString();
       return userDAO.findUserLogIn(userName, password);
    } */

    public Integer updateUserName(String userName,String email){
        Integer updatedRow=userDAO.updateUserName(userName, email);
        return updatedRow;
    }


    public Integer updateLogIn(boolean loggedIn,String userName){
        Integer updateRow=userDAO.updateLogIn(loggedIn,userName);
        return updateRow;
    }


    public Integer deleteUser(String userName ){
        Integer updatedRow=userDAO.deleteUser(userName);
        return updatedRow;
    }
}
