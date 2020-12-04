package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.City;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CityDAO {

    public void insertCity(City city){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
    }

    public City findCity(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findCity=session.createNamedQuery("selectCity");
        findCity.setParameter("name",name);
        City city=(City) findCity.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public Integer deleteCityByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteCityByName=session.createNamedQuery("deleteCity");
        deleteCityByName.setParameter("name",name);
        Integer deletedRow=deleteCityByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedRow;
    }
}