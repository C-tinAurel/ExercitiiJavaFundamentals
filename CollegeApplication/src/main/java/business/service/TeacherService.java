package business.service;

import business.dto.StudentDTO;
import business.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.TeacherDAO;
import persistence.entitites.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDAO teacherDAO;


    public List<TeacherDTO> showTeacherList() {
        TeacherDTO teacherDTO=new TeacherDTO();
        List<Teacher> teachers = teacherDAO.allTeacher();
        List<TeacherDTO> teacherDTOList =new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTO.setName(teacher.getName());
            teacherDTO.setSurname(teacher.getSurname());
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    public void insert(TeacherDTO teacherDTO) {
        Teacher teacher=new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setSurname(teacherDTO.getSurname());
        teacher.setSubject(teacherDTO.getSubject());
        teacherDAO.insert(teacher);

    }


}
