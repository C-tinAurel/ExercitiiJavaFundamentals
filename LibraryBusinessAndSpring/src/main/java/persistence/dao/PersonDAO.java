package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Book;
import persistence.entities.Person;

import javax.persistence.Query;
import java.util.List;
@Repository
public class PersonDAO {
    public void insert(Person person){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public List<Person> findPersonByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryfindPersonByName=session.createNamedQuery("FindPersonByName");
        queryfindPersonByName.setParameter("name",name);
        List<Person> personList=queryfindPersonByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return personList;
    }
    public void deleteYearOfBirth(int yearOfBirth){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteYearOfBirth=session.createNamedQuery("DeletePersonByYearOfBirth");
        queryDeleteYearOfBirth.setParameter("yearOfBirth",yearOfBirth);
        queryDeleteYearOfBirth.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
