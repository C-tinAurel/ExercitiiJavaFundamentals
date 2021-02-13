package frontend;

import business.dto.DepartmentDTO;
import business.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(path = "/insertDepartment")
    public String insertDepartment(@RequestBody @Valid DepartmentDTO insertDepartment) {
        departmentService.insertDepartment(insertDepartment);
        return "Ati introdus cu succes Departamentul " + insertDepartment.getName();
    }

    @DeleteMapping(path = "/deleteDepartment")
    public String deleteDepartmentByName(@RequestParam String name) {
        Integer numberOfDeletedDepartament = departmentService.deleteDepartmentByName(name);
        if (numberOfDeletedDepartament > 0) {
            return "Departamentul " + name + " a fost sters cu succes";
        } else {
            return "Departamentul nu a fost sters inca :(";
        }
    }

    @GetMapping(path = "/findDepartment")
    public List<DepartmentDTO> findDepartmentByName(@RequestParam String name) {
        List<DepartmentDTO> departmentDTOList = departmentService.findDepartmentByName(name);
        return departmentDTOList;
    }
}
