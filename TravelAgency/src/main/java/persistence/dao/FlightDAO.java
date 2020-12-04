package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Flight;

import javax.persistence.Query;

import java.util.List;

@Repository
public class FlightDAO {

    public void insertFlight(Flight flight){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(flight);
        session.getTransaction().commit();
        session.close();
    }

    public List<Flight> findFlightByAirport(String airportName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findFlightByAirport=session.createNamedQuery("selectAllFlightsFromAirport");
        findFlightByAirport.setParameter("name",airportName);
        List<Flight> flightList=findFlightByAirport.getResultList();
        session.getTransaction().commit();
        session.close();
        return flightList;

    }

    public Integer updateFlightByHour(String flightHour,String flightTo){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateFlightByHour=session.createNamedQuery("updateFlightHour");
        updateFlightByHour.setParameter("flightHour",flightHour);
        updateFlightByHour.setParameter("flightTo",flightTo);
        Integer updatedRow=updateFlightByHour.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer updateFlightByData(String flightData,String flightTo){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateFlightByData=session.createNamedQuery("updateFlightData");
        updateFlightByData.setParameter("flightData",flightData);
        updateFlightByData.setParameter("flightTo",flightTo);
        Integer updatedRow=updateFlightByData.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer updateFlightPrice(int price,String flightTo){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateFlightByPrice=session.createNamedQuery("updateFlightPrice");
        updateFlightByPrice.setParameter("price",price);
        updateFlightByPrice.setParameter("flightTo",flightTo);
        Integer updatedRow=updateFlightByPrice.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer deleteFlight(String flightTo){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteFlight=session.createNamedQuery("deleteFlight");
        deleteFlight.setParameter("flightTo",flightTo);
        Integer updatedRow=deleteFlight.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }
}
