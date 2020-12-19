package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.User;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAO {

    public void insertUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User findUserByName(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findUserByName = session.createNamedQuery("selectUserName");
        findUserByName.setParameter("userName", userName);
        User user = (User) findUserByName.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public String findUserLogIn(String userName, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findUserLogIn = session.createNamedQuery("checkUserByPassword");
        findUserLogIn.setParameter("password", password);
        findUserLogIn.setParameter("userName", userName);
        String user = (String) findUserLogIn.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public Integer updateLogIn(boolean loggedIn, String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateLogIn = session.createNamedQuery("updateUserLogIn");
        updateLogIn.setParameter("loggedIn", loggedIn);
        updateLogIn.setParameter("userName", userName);
        Integer updatedRow = updateLogIn.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer updateUserName(String userName, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateUserEmail = session.createNamedQuery("updateUserName");
        updateUserEmail.setParameter("email", email);
        updateUserEmail.setParameter("userName", userName);
        Integer updatedRow = updateUserEmail.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer deleteUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteUser = session.createNamedQuery("deleteUserName");
        deleteUser.setParameter("userName", userName);
        Integer deletedRow = deleteUser.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedRow;
    }
}

