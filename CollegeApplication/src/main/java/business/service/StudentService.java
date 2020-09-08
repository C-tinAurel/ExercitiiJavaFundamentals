package business.service;

import business.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.StudentDAO;
import persistence.entitites.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public List<StudentDTO> findAll() {
        List<Student> studentList = studentDAO.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName().toUpperCase());
            studentDTO.setSurname(student.getSurname());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public void insert(StudentDTO studentDTO) {
        Student student=new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setAge(studentDTO.getAge());
        studentDAO.insert(student);

    }
}
