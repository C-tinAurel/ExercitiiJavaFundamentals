package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Room;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomDAO {

    public void insertRoom(Room room) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
        session.close();
    }

    public Integer updateRoomNumberAvailable(int numberAvailable,String type){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateRoomNumberAvailable=session.createNamedQuery("updateRoomNumberAvailable");
        updateRoomNumberAvailable.setParameter("numberAvailable",numberAvailable);
        updateRoomNumberAvailable.setParameter("type",type);
        Integer updatedRow=updateRoomNumberAvailable.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

}
