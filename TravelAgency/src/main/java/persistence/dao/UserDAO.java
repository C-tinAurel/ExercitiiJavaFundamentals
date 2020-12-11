package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.User;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAO {

    public void insertUser(User user){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> findUserByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findUserByName=session.createNamedQuery("selectUserName");
        findUserByName.setParameter("name",name);
        List<User> userList=findUserByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    public List<User> findUserByEmail(String email){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findUserByEmail=session.createNamedQuery("selectUserEmail");
        findUserByEmail.setParameter("email",email);
        List<User> userList=findUserByEmail.getResultList();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    public Integer updateUserName(String email,String userName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateUserEmail=session.createNamedQuery("updateUserName");
        updateUserEmail.setParameter("email",email);
        updateUserEmail.setParameter("userName",userName);
        Integer updatedRow=updateUserEmail.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer deleteUser(String userName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteUser=session.createNamedQuery("deleteUserName");
        deleteUser.setParameter("userName",userName);
        Integer deletedRow=deleteUser.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedRow;
    }
}

