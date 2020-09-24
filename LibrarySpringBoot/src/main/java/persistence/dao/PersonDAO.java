package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Person;


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
        Query queryFindPersonByName=session.createNamedQuery("SelectPersonByName");
        queryFindPersonByName.setParameter("name",name);
        List<Person> personList=queryFindPersonByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return personList;
    }

    public Integer deletePersonByYearOfBirth(int yearOfBirth){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeletePersonByYearOfBirth=session.createNamedQuery("DeletePersonByYearOfBirth");
        queryDeletePersonByYearOfBirth.setParameter("yearOfBirth",yearOfBirth);
         Integer numberOfDeletePersonByYear= queryDeletePersonByYearOfBirth.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfDeletePersonByYear;
    }
    public Integer updatePersonByAddress(String address,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdatePersonbyAddress=session.createNamedQuery("UpdatePersonByAddress");
        queryUpdatePersonbyAddress.setParameter("address",address);
        queryUpdatePersonbyAddress.setParameter("name",name);
        Integer numberOfUpdatedPersonByAddress=queryUpdatePersonbyAddress.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfUpdatedPersonByAddress;
    }
}
