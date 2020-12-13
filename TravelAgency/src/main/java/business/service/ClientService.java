package business.service;

import business.dto.ClientDTO;
import business.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import persistence.dao.ClientDAO;
import persistence.entities.Client;
import persistence.entities.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ClientService {
    @Autowired
    ClientDAO clientDAO;
    @Autowired
    UserService userService;

    public void insertClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setAddress(clientDTO.getAddress());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setYearOfBirth(clientDTO.getYearOfBirth());
        User user = new User();
        user.setUserName(clientDTO.getUserDTO().getUserName());
        System.out.println("Afisam inainte de criptare la introducere User-ului " + clientDTO.getUserDTO().getPassword());
        setPassword(clientDTO, user);
        user.setEmail(clientDTO.getUserDTO().getEmail());
        user.setClient(client);
        client.setUser(user);
        clientDAO.insertClient(client);

    }

    public void setPassword(ClientDTO clientDTO, User user) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger=new BigInteger(1, messageDigest.digest(clientDTO.getUserDTO().getPassword().getBytes()));
        String passwordCrypt = bigInteger.toString();
        user.setPassword(passwordCrypt);
    }


    public ClientDTO findClient(String name, String surname) {
        Client client = clientDAO.findClient(name, surname);
        if (client == null) {
            return null;
        }
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setYearOfBirth(client.getYearOfBirth());
        return clientDTO;
    }


    public ClientDTO findClientByUser(String userName, String password) {
        System.out.println("Aici afisam userName " + userName + " " + " Aici afisam parola " + password);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger=new BigInteger(1, messageDigest.digest(password.getBytes()));
        String passwordCrypt = bigInteger.toString();
        System.out.println("Afisam parola criptata " + passwordCrypt);
        Client client = clientDAO.findClientByUser(userName, passwordCrypt);
        if (client == null) {
            return null;
        }
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setYearOfBirth(client.getYearOfBirth());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(client.getUser().getUserName());
        userDTO.setEmail(client.getUser().getEmail());
        clientDTO.setUserDTO(userDTO);
        return clientDTO;
    }


    public Integer updateClientAddress(String address, String name, String surname) {
        Integer updatedRow = clientDAO.updateClientAddress(address, name, surname);
        return updatedRow;
    }

    public Integer updateClientPhone(int phoneNumber, String name, String surname) {
        Integer updatedRow = clientDAO.updateClientPhone(phoneNumber, name, surname);
        return updatedRow;
    }

    public Integer deleteClient(String name, String surname) {
        Integer updatedRow = clientDAO.deleteClient(name, surname);
        return updatedRow;
    }

}

