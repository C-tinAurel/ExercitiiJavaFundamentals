package frontend;

import business.dto.EmployeeDTO;
import business.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/insertEmployee")
    public String insertEmployee(@RequestBody @Valid EmployeeDTO insertEmployee) {
        employeeService.insertEmployee(insertEmployee);
        return "Ati introdus Angajatul " + insertEmployee.getName() + " " + insertEmployee.getSurname();
    }

    @GetMapping(path = "/findEmployee")
    public List<EmployeeDTO> findEmployeeByName(@RequestParam String name) {
        System.out.println("Ati introdus angajatul " + name);
        List<EmployeeDTO> employeeDTOList = employeeService.findEmployeeByName(name);
        return employeeDTOList;
    }

    @DeleteMapping(path = "/deleteEmployee")
    public String deleteEmployeeByAge(@RequestParam int age) {
        Integer numberOfDeletedEmployee = employeeService.deleteEmployeeByAge(age);
        if (numberOfDeletedEmployee > 0) {
            return "Ati sters cu succes angajatii cu varsta " + age;
        } else {
            return "Angajatul nu a putut fi sters";
        }
    }

    @PutMapping(path = "/updateEmployee")
    public String updateEmployeeSurname(@RequestParam String surname, @RequestParam String name) {
        Integer numberOfUpdatedEmployee = employeeService.updateEmployeeSurname(surname, name);
        if (numberOfUpdatedEmployee > 0) {
            return "Ati actualizat cu succes angajatul ";
        } else {
            return "Nu s-a actualizat angajatul";
        }
    }
}
