package business.service.product;

import business.dto.product.CementDTO;
import business.dto.DepartmentDTO;
import business.dto.DepositDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.DepartmentDAO;
import persistence.dao.DepositDAO;
import persistence.dao.product.CementDAO;
import persistence.entities.product.Cement;
import persistence.entities.Department;
import persistence.entities.Deposit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CementService {
    @Autowired
    CementDAO cementDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    public void insert(CementDTO cementDTO) {
        Cement cement = new Cement();
        cement.setName(cementDTO.getName());
        cement.setGranulation(cementDTO.getGranulation());
        cement.setPrice(cementDTO.getPrice());
        cement.setStock(cementDTO.getStock());
        Department department = new Department();
        department.setName(cementDTO.getDepartmentDTO().getName());
        cement.setDepartment(department);
        Set<Deposit> deposits = new HashSet<>();
        for (DepositDTO depositDTO : cementDTO.getDepositDTOSet()) {
            Deposit deposit = new Deposit();
            deposit.setCity(depositDTO.getCity());
            deposit.setAddress(depositDTO.getAddress());
            deposits.add(deposit);
        }
        setCementDepartment(cementDTO, cement);
        cement.setDepositSet(deposits);
        cementDAO.insert(cement);
    }

    public List<CementDTO> findCementByName(String name) {
        List<Cement> cementList = cementDAO.findCementByName(name);
        List<CementDTO> cementDTOList = new ArrayList<>();
        for (Cement cement : cementList) {
            CementDTO cementDTO = new CementDTO();
            cementDTO.setName(cement.getName());
            cementDTO.setGranulation(cement.getGranulation());
            cementDTO.setStock(cement.getStock());
            cementDTO.setPrice(cement.getPrice());
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(cement.getDepartment().getName());
            cementDTO.setDepartmentDTO(departmentDTO);
            Set<DepositDTO> depositDTOList = new HashSet<>();
            for (Deposit deposit : cement.getDepositSet()) {
                DepositDTO depositDTO = new DepositDTO();
                depositDTO.setCity(deposit.getCity());
                depositDTO.setAddress(deposit.getAddress());
                depositDTOList.add(depositDTO);
            }
            cementDTO.setDepositDTOSet(depositDTOList);
            cementDTOList.add(cementDTO);
        }
        return cementDTOList;
    }


    public void setCementDepartment(CementDTO cementDTO, Cement cement) {
        Department departmentCement=null;
        departmentCement=departmentDAO.findDepartmentByName(cementDTO.getDepartmentDTO().getName());
        if(departmentCement==null){
            departmentCement=new Department();
            departmentCement.setName(cementDTO.getDepartmentDTO().getName());
        }
        cement.setDepartment(departmentCement);
    }

    public Integer updateCementGranulation(String granulation, String name) {
        Integer numberOfUpdatedGranulation = cementDAO.updateCementByGranulation(granulation, name);
        return numberOfUpdatedGranulation;
    }

    public Integer deleteCementGranulation(String granulation) {
        Integer numberOfDeletedCementGranulation = cementDAO.deleteCementByGranulation(granulation);
        return numberOfDeletedCementGranulation;
    }
}

