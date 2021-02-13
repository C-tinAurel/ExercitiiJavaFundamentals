package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.UserRegistration;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRegistrationDAO {

    public void insertUser(UserRegistration userRegistration) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userRegistration);
        session.getTransaction().commit();
        session.close();
    }

    public List<UserRegistration> findUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindUserName = session.createNamedQuery("SelectUserByName");
        queryFindUserName.setParameter("name", name);
        List<UserRegistration> userRegistrationList = queryFindUserName.getResultList();
        session.getTransaction().commit();
        session.close();
        return userRegistrationList;
    }

    public Integer updateUserSurname(String surname, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateUserSurname = session.createNamedQuery("UpdatedUserSurname");
        queryUpdateUserSurname.setParameter("surname", surname);
        queryUpdateUserSurname.setParameter("name", name);
        queryUpdateUserSurname.executeUpdate();
        Integer updatedUser = queryUpdateUserSurname.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedUser;
    }

    public Integer deleteUserByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteUserEmail = session.createNamedQuery("DeleteUserByEmail");
        queryDeleteUserEmail.setParameter("email", email);
        Integer numberOfDeleted = queryDeleteUserEmail.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfDeleted;
    }
}

