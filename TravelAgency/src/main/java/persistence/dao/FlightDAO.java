package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Airport;
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
        Query findFlightByAirport=session.createNamedQuery("selectFlightsFromAirport");
        findFlightByAirport.setParameter("name",airportName);
        List<Flight> flightList=findFlightByAirport.getResultList();
        session.getTransaction().commit();
        session.close();
        return flightList;

    }


    public Flight findFlightByFlightNumber(String flightNumber){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findFlightByFlightNumber=session.createNamedQuery("selectFlightByFlightNumber");
        findFlightByFlightNumber.setParameter("flightNumber",flightNumber);
        Flight flight=(Flight) findFlightByFlightNumber.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return flight;
    }
}
