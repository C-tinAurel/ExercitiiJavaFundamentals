package entryPoint;

import business.dto.StudentDTO;
import business.dto.TeacherDTO;
import business.service.StudentService;
import business.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollegeEntryPoint {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    public void run() {

        List<StudentDTO> studentDTOList = studentService.findAll();
        for (StudentDTO studentDTO : studentDTOList) {
            System.out.println("Afisam studentii " + studentDTO);
        }

        StudentDTO studentDTO = new StudentDTO("George", "Marin", 30);
        studentService.insert(studentDTO);


        List<TeacherDTO> teacherDTOList = teacherService.showTeacherList();
        for (TeacherDTO teacherDTO : teacherDTOList) {
            System.out.println("Afisam profesorii " + teacherDTO);
        }
        TeacherDTO teacherDTO = new TeacherDTO("Vasile", "Manole", "Matematica");
        teacherService.insert(teacherDTO);
    }
}
