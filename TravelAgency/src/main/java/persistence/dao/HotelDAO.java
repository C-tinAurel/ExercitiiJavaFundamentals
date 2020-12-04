package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Hotel;

import javax.persistence.Query;
import java.util.List;

@Repository
public class HotelDAO {

    public void insertHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    public List<Hotel> findHotelByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelName = session.createNamedQuery("selectHotelName");
        findHotelName.setParameter("name", name);
        List<Hotel> hotelList = findHotelName.getResultList();
        session.getTransaction().commit();
        session.close();
        return hotelList;

    }

    public List<Hotel> findHotelByCity(String nameHotel,String cityName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelByCity = session.createNamedQuery("selectHotelByCity");
        findHotelByCity.setParameter("name",nameHotel);
        findHotelByCity.setParameter("name", cityName);
        List<Hotel> hotelList = findHotelByCity.getResultList();
        session.getTransaction().commit();
        session.close();
        return hotelList;

    }

    public List<Hotel> findHotelByAvailableRoomAndType(String hotelName,String roomAvailable,String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelByAvailableRoom = session.createNamedQuery("selectHotelByRoomAvailable");
        findHotelByAvailableRoom.setParameter("name",hotelName);
        findHotelByAvailableRoom.setParameter("numberAvailable", roomAvailable);
        findHotelByAvailableRoom.setParameter("type",type);
        List<Hotel> hotelList = findHotelByAvailableRoom.getResultList();
        session.getTransaction().commit();
        session.close();
        return hotelList;
    }
    public List<Hotel> findHotelWithExtraBed(String name,boolean extraBed){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findHotelWithExtraBed=session.createNamedQuery("selectHotelByExtraBedRoom");
        findHotelWithExtraBed.setParameter("name",name);
        findHotelWithExtraBed.setParameter("extraBed",extraBed);
        List<Hotel> hotelList=findHotelWithExtraBed.getResultList();
        session.getTransaction().commit();
        session.close();
        return hotelList;
    }

    public Integer updateHotelStars(int stars, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateHotelStars = session.createNamedQuery("updateHotelStars");
        updateHotelStars.setParameter("stars", stars);
        updateHotelStars.setParameter("name", name);
        Integer updatedRow = updateHotelStars.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer updateHotelDescription(String description, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateHotelDescription = session.createNamedQuery("updateHotelDescription");
        updateHotelDescription.setParameter("description", description);
        updateHotelDescription.setParameter("name", name);
        Integer updatedRow = updateHotelDescription.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer deleteHotel(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteHotel = session.createNamedQuery("deleteHotel");
        deleteHotel.setParameter("name", name);
        Integer deletedRow = deleteHotel.executeUpdate();
        session.beginTransaction().commit();
        session.close();
        return deletedRow;

    }
}
