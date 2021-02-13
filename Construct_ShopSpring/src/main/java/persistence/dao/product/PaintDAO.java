package persistence.dao.product;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.product.Paint;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PaintDAO {

    public void insert(Paint paint) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(paint);
        session.getTransaction().commit();
        session.close();
    }

    public List<Paint> findPaintByColor(String color) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindPaintColor = session.createNamedQuery("SelectPaintByColor");
        queryFindPaintColor.setParameter("color", color);
        List<Paint> paintList = queryFindPaintColor.getResultList();
        session.getTransaction().commit();
        session.close();
        return paintList;
    }

    public Integer deletePaintColor(String color) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeletePaintColor = session.createNamedQuery("DeletePaintColor");
        queryDeletePaintColor.setParameter("color", color);
        Integer deletedPaint = queryDeletePaintColor.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedPaint;
    }

    public Integer updatePaintMark(String mark,String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdatePaintMark = session.createNamedQuery("UpdatePaintByMark");
        queryUpdatePaintMark.setParameter("mark", mark);
        queryUpdatePaintMark.setParameter("name",name);
        Integer updatedPaint=queryUpdatePaintMark.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedPaint;
    }
}
