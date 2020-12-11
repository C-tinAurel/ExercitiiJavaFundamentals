package business.service;

import business.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ClientDAO;
import persistence.entities.Client;
import persistence.entities.User;

@Service
public class ClientService {
    @Autowired
    ClientDAO clientDAO;

    public void insertClient(ClientDTO clientDTO){
        Client client=new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setAddress(clientDTO.getAddress());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setYearOfBirth(clientDTO.getYearOfBirth());
        User user=new User();
        user.setUserName(clientDTO.getUserDTO().getUserName());
        user.setPassword(clientDTO.getUserDTO().getPassword());
        user.setEmail(clientDTO.getUserDTO().getEmail());
        user.setClient(client);
        client.setUser(user);
        clientDAO.insertClient(client);

    }

    public ClientDTO findClient(String name, String surname){
        Client client=clientDAO.findClient(name, surname);
        if(client==null){
            return null;
        }
        ClientDTO clientDTO=new ClientDTO();
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhoneNumber(client.getPhoneNumber());
        clientDTO.setYearOfBirth(client.getYearOfBirth());
        return clientDTO;
    }

    public Integer updateClientAddress(String address, String name, String surname){
        Integer updatedRow=clientDAO.updateClientAddress(address, name, surname);
        return updatedRow;
    }

    public Integer updateClientPhone(int phoneNumber,String name,String surname){
        Integer updatedRow=clientDAO.updateClientPhone(phoneNumber, name, surname);
        return updatedRow;
    }

    public Integer deleteClient(String name,String surname){
        Integer updatedRow=clientDAO.deleteClient( name, surname);
        return updatedRow;
    }
}
