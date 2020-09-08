package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Teacher;

import javax.persistence.Query;
import java.util.List;
@Repository
public class TeacherDAO {

    public List<Teacher> allTeacher() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryAllTeacher = session.createNamedQuery("SelectAllTeachers");
        List<Teacher> findAllTeacher = queryAllTeacher.getResultList();
         session.getTransaction().commit();
         session.close();
         return findAllTeacher;
    }
    public void insert(Teacher teacher){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }
}
