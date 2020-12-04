package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Purchase;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PurchaseDAO {

    public void insertPurchase(Purchase purchase) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(purchase);
        session.getTransaction().commit();
        session.close();
    }

    public List<Purchase> findPurchaseByTrip(String tripName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPurchaseByTrip = session.createNamedQuery("selectPurchaseByTrip");
        findPurchaseByTrip.setParameter("name", tripName);
        List<Purchase> purchaseList = findPurchaseByTrip.getResultList();
        session.getTransaction().commit();
        session.close();
        return purchaseList;
    }
}
