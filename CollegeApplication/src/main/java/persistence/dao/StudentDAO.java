package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Student;

import javax.persistence.Query;
import java.util.List;
@Repository
public class StudentDAO {

    public List<Student> findAll(){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindAll=session.createNamedQuery("Select_All");
        List<Student> resultFindAll=queryFindAll.getResultList();
        session.getTransaction().commit();
       session.close();
       return resultFindAll;
    }
    public void insert(Student student){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }


}
