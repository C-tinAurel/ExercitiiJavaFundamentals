package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Trip;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TripDAO {

    public void insertTrip(Trip trip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();
    }

    public Trip findTripByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripByName = session.createNamedQuery("selectTripName");
        findTripByName.setParameter("name", name);
        Trip trip = (Trip) findTripByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return trip;
    }

    public List<Trip> findTriPromoted(String name, boolean promoted) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTripWithPromoted = session.createNamedQuery("selectTripPromoted");
        findTripWithPromoted.setParameter("name", name);
        findTripWithPromoted.setParameter("promoted", promoted);
        List<Trip> tripList = findTripWithPromoted.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findAllTrips(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAllTripsQuery=session.createNamedQuery("findAllTrips");
        List<Trip> tripList=findAllTripsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripByCity(String cityName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query searchTripByCity=session.createNamedQuery("findTripByCity");
        searchTripByCity.setParameter("name",cityName);
        List<Trip> tripList=searchTripByCity.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripByCountry(String countryName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindTripByCountry=session.createNamedQuery("findTripByCountry");
        queryFindTripByCountry.setParameter("name",countryName);
        List<Trip> tripList= queryFindTripByCountry.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripByContinent(String continentName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindTripByContinent=session.createNamedQuery("findTripByContinent");
        queryFindTripByContinent.setParameter("name",continentName);
        List<Trip> tripList=queryFindTripByContinent.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public List<Trip> findTripRecently(String departureDate){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindTripRecently=session.createNamedQuery("findTripRecently");
        queryFindTripRecently.setParameter("departureDate",departureDate);
        List<Trip> tripList=queryFindTripRecently.getResultList();
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    public Integer updateTripNumberOfDays(int numberDay,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateTrip=session.createNamedQuery("updateNumbersOfDays");
        updateTrip.setParameter("numberDay",numberDay);
        updateTrip.setParameter("name",name);
        Integer updateRow=updateTrip.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updateRow;
    }

    public Integer updateTripAvailableStock(int availableStock,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateAvailableStock=session.createNamedQuery("updateAvailableStock");
        updateAvailableStock.setParameter("availableStock",availableStock);
        updateAvailableStock.setParameter("name",name);
        Integer updateRow=updateAvailableStock.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updateRow;
    }

    public Integer deleteTrip(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteTrip=session.createNamedQuery("deleteTrip");
        queryDeleteTrip.setParameter("name",name);
        Integer updateRow=queryDeleteTrip.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updateRow;

    }
}
