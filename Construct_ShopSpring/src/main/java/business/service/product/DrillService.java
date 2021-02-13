package business.service.product;

import business.dto.DepartmentDTO;
import business.dto.DepositDTO;
import business.dto.product.DrillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.DepartmentDAO;
import persistence.dao.product.DrillDAO;
import persistence.entities.Department;
import persistence.entities.Deposit;
import persistence.entities.product.Drill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DrillService {
    @Autowired
    DrillDAO drillDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    public void insertDrillDTO(DrillDTO drillDTO) {
        Drill drill = new Drill();
        drill.setName(drillDTO.getName());
        drill.setMark(drillDTO.getMark());
        drill.setBattery(drillDTO.isBattery());
        drill.setPrice(drillDTO.getPrice());
        drill.setStock(drillDTO.getStock());
        Department department = new Department();
        department.setName(drillDTO.getDepartmentDTO().getName());
        drill.setDepartment(department);
        Set<Deposit> depositSet = new HashSet<>();
        for (DepositDTO depositDTO : drillDTO.getDepositDTOSet()) {
            Deposit deposit = new Deposit();
            deposit.setCity(depositDTO.getCity());
            deposit.setAddress(depositDTO.getAddress());
            depositSet.add(deposit);
        }
        setDepartment(drillDTO, drill);
        drill.setDepositSet(depositSet);
        drillDAO.insert(drill);
    }

    public void setDepartment(DrillDTO drillDTO, Drill drill) {
        Department departmentDrill = null;
        departmentDrill = departmentDAO.findDepartmentByName(drillDTO.getDepartmentDTO().getName());
        if (departmentDrill == null) {
            departmentDrill = new Department();
            departmentDrill.setName(drillDTO.getDepartmentDTO().getName());
        }
        drill.setDepartment(departmentDrill);
    }

    public List<DrillDTO> findDrillDTOMark(String mark) {
        List<Drill> drills = drillDAO.findDrillByMark(mark);
        List<DrillDTO> drillDTOS = new ArrayList<>();
        for (Drill drill : drills) {
            DrillDTO drillDTO = new DrillDTO();
            drillDTO.setName(drill.getName());
            drillDTO.setMark(drill.getMark());
            drillDTO.setBattery(drill.isBattery());
            drillDTO.setPrice(drill.getPrice());
            drillDTO.setStock(drill.getStock());
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(drill.getDepartment().getName());
            drillDTO.setDepartmentDTO(departmentDTO);
            Set<DepositDTO> depositDTOSet = new HashSet<>();
            for (Deposit deposit : drill.getDepositSet()) {
                DepositDTO depositDTO = new DepositDTO();
                depositDTO.setCity(deposit.getCity());
                depositDTO.setAddress(deposit.getAddress());
                depositDTOSet.add(depositDTO);
            }
            drillDTO.setDepositDTOSet(depositDTOSet);
            drillDTOS.add(drillDTO);

        }
        return drillDTOS;
    }

    public Integer deleteDrillByMark(String mark) {
        Integer numberOfDeletedDrillRow = drillDAO.deleteDrillMark(mark);
        return numberOfDeletedDrillRow;
    }

    public Integer updateDrillMark(String mark, String name) {
        Integer numberOfUpdatedDrillRow = drillDAO.updateDrillMark(mark, name);
        return numberOfUpdatedDrillRow;
    }
}
