package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Trip;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TripDAO {

    public void insertTrip(Trip trip){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    public List<Trip> findTripByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripByName=session.createNamedQuery("selectTripName");
        findTripByName.setParameter("name",name);
        List<Trip> tripList=findTripByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripWithPromoted(String name,boolean promoted){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripWithPromoted=session.createNamedQuery("selectTripPromoted");
        findTripWithPromoted.setParameter("name",name);
        findTripWithPromoted.setParameter("promoted",promoted);
        List<Trip> tripList=findTripWithPromoted.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }
}
