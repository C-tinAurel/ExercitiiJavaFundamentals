package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Deposit;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DepositDAO {

    public void insert(Deposit deposit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(deposit);
        session.getTransaction().commit();
        session.close();
    }

    public List<Deposit> findDepositByCity(String city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindDepositBName = session.createNamedQuery("SelectDepositByCity");
        queryFindDepositBName.setParameter("city",city);
        List<Deposit> depositList = queryFindDepositBName.getResultList();
        session.getTransaction().commit();
        session.close();
        return depositList;
    }
    public Integer deleteDepositByAddress(String address){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteDepositByAddress=session.createNamedQuery("DeleteDepositByAddress");
        queryDeleteDepositByAddress.setParameter("address",address);
        Integer deletedDepositByAddress=queryDeleteDepositByAddress.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedDepositByAddress;
    }
    public Integer updateDepositAddress(String address,String city){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateDepositName=session.createNamedQuery("UpdateDepositAddress");
        queryUpdateDepositName.setParameter("address",address);
        queryUpdateDepositName.setParameter("city",city);
        Integer numberOfUpdatedDepositName=queryUpdateDepositName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfUpdatedDepositName;
    }
    }