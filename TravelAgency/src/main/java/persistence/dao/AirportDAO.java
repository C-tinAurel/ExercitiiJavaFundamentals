package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Airport;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AirportDAO {

    public void insertAirport(Airport airport) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(airport);
        session.getTransaction().commit();
        session.close();
    }

    public void insertAirport(Airport airport,Session session){
        session.save(airport);
    }

    public Airport findAirportByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findAirportName = session.createNamedQuery("selectAirport");
        findAirportName.setParameter("name", name);
        Airport airport = (Airport) findAirportName.uniqueResult();
        if (airport==null){
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return airport;
    }

    public Airport findAirportByName(String name,Session session) {
        org.hibernate.query.Query findAirportName = session.createNamedQuery("selectAirport");
        findAirportName.setParameter("name", name);
        Airport airport = (Airport) findAirportName.uniqueResult();
        if (airport==null){
            return null;
        }
        return airport;
    }

    public List<Airport> findAirportByCity(String cityName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAirportByCity = session.createNamedQuery("selectAirportByCity");
        findAirportByCity.setParameter("name", cityName);
        List<Airport> airportList = findAirportByCity.getResultList();
        session.getTransaction().commit();
        session.close();
        return airportList;
    }

    public Integer updateAirportName(String newName,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateAirportName=session.createNamedQuery("updateAirportName");
        updateAirportName.setParameter("newName",newName);
        updateAirportName.setParameter("name",name);
        Integer updatedRow=updateAirportName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }
}
