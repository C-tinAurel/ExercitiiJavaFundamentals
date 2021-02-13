package persistence.dao.product;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.product.Drill;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DrillDAO {

    public void insert(Drill drill){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(drill);
        session.getTransaction().commit();
        session.close();
    }

    public List<Drill> findDrillByMark(String mark){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindDrillMark=session.createNamedQuery("SelectCementByName");
        queryFindDrillMark.setParameter("mark",mark);
        List<Drill>  findDrillByMark=queryFindDrillMark.getResultList();
        session.getTransaction().commit();
        session.close();
        return findDrillByMark;
    }

    public Integer updateDrillMark(String mark,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateDrillMark=session.createNamedQuery("UpdateDrillMark");
        queryUpdateDrillMark.setParameter("mark",mark);
        queryUpdateDrillMark.setParameter("name",name);
        Integer updatedRowDrill=queryUpdateDrillMark.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRowDrill;
    }

    public Integer deleteDrillMark(String mark){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteDrillMark=session.createNamedQuery("DeleteDrillByMark");
        queryDeleteDrillMark.setParameter("mark",mark);
        Integer deletedRowDrill=queryDeleteDrillMark.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedRowDrill;
    }
}
