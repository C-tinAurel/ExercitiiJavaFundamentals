package business.service;

import business.dto.DepositDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.DepositDAO;
import persistence.entities.Deposit;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    DepositDAO depositDAO;


    public void insert(DepositDTO depositDTO) {
        Deposit deposit = new Deposit();
        deposit.setCity(depositDTO.getCity());
        deposit.setAddress(depositDTO.getAddress());
        depositDAO.insert(deposit);
    }


    public List<DepositDTO> findDepositByCity(String city) {
        List<Deposit> depositList = depositDAO.findDepositByCity(city);
        List<DepositDTO> depositDTOList = new ArrayList<>();
        for (Deposit deposit : depositList) {
            DepositDTO depositDTO = new DepositDTO();
            depositDTO.setCity(deposit.getCity());
            depositDTO.setAddress(deposit.getAddress());
            depositDTOList.add(depositDTO);
        }
        return depositDTOList;
    }

    public Integer deleteDepositByAddress(String address) {
        Integer numberOfDeletedDeposits = depositDAO.deleteDepositByAddress(address);
        return numberOfDeletedDeposits;
    }

    public Integer updateDepositAddress(String address, String city) {
        Integer updatedDeposits = depositDAO.updateDepositAddress(address, city);
        return updatedDeposits;
    }
}
