package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Cement;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CementDAO {

    public void insert(Cement cement) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(cement);
        session.getTransaction().commit();
        session.close();
    }

    public List<Cement> findCementByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindCementByName = session.createNamedQuery("SelectCementByName");
        queryFindCementByName.setParameter("name", name);
        List<Cement> cementList = queryFindCementByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return cementList;
    }

    public Integer updateCementByGranulation(String granulation, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateCementGranulation = session.createNamedQuery("UpdateCementGranulation");
        queryUpdateCementGranulation.setParameter("granulation", granulation);
        queryUpdateCementGranulation.setParameter("name", name);
        Integer numberUpdatedCement = queryUpdateCementGranulation.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberUpdatedCement;
    }

    public Integer deleteCementByGranulation(String granulation){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteCementGranulation=session.createNamedQuery("DeleteCementByGranulation");
        queryDeleteCementGranulation.setParameter("granulation",granulation);
        Integer numberDeletedCementGranulation=queryDeleteCementGranulation.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberDeletedCementGranulation;
    }
}
