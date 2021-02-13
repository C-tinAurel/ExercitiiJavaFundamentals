package business.service;


import business.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.DepartmentDAO;
import persistence.entities.Department;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;


    public void insertDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        departmentDAO.insert(department);
    }

    public Integer deleteDepartmentByName(String name) {
        Integer numberOfDeletedDepartment = departmentDAO.deleteDepartmentByName(name);
        return numberOfDeletedDepartment;
    }

    public List<DepartmentDTO> findDepartmentByName(String name) {
        List<Department> departmentList = (List<Department>) departmentDAO.findDepartmentByName(name);
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentList) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(department.getName());
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }

}
