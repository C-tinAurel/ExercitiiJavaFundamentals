package business.service;

import business.dto.DepartmentDTO;
import business.dto.DepositDTO;
import business.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.EmployeeDAO;
import persistence.entities.Department;
import persistence.entities.Deposit;
import persistence.entities.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<EmployeeDTO> findEmployeeByName(String name) {
        List<Employee> employeeList = employeeDAO.findEmployeeByName(name);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            DepositDTO depositDTO = new DepositDTO();
            DepartmentDTO departmentDTO = new DepartmentDTO();
            employeeDTO.setName(employee.getName());
            employeeDTO.setSurname(employee.getSurname());
            employeeDTO.setAge(employee.getAge());
            depositDTO.setCity(employee.getDeposit().getCity());
            depositDTO.setAddress(employee.getDeposit().getAddress());
            employeeDTO.setDepositDTO(depositDTO);
            departmentDTO.setName(employee.getDepartment().getName());
            employeeDTO.setDepartmentDTO(departmentDTO);
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

    public void insertEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        Deposit deposit = new Deposit();
        Department department = new Department();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setAge(employeeDTO.getAge());
        System.out.println("Aici afisam orasul " +employeeDTO.getDepositDTO().getCity());
        deposit.setCity(employeeDTO.getDepositDTO().getCity());
        deposit.setAddress(employeeDTO.getDepositDTO().getAddress());
        employee.setDeposit(deposit);
        department.setName(employeeDTO.getDepartmentDTO().getName());
        employee.setDepartment(department);
        employeeDAO.insertEmployee(employee);
    }

    public Integer deleteEmployeeByAge(int age) {
        Integer numberOfDEletedEmployee = employeeDAO.deleteEmployeeByAge(age);
        return numberOfDEletedEmployee;
    }

    public Integer updateEmployeeSurname(String surname, String name) {
        Integer numberOfUpatedEmployee = employeeDAO.updateEmployeeSurname(surname, name);
        return numberOfUpatedEmployee;
    }
}
