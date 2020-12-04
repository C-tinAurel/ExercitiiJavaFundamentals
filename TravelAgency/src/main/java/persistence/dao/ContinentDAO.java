package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Continent;
import org.hibernate.query.Query;
import javax.persistence.NoResultException;




@Repository
public class ContinentDAO {

    public void insertContinent(Continent continent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(continent);
        session.getTransaction().commit();
        session.close();
    }

    public Continent findContinent(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindContinent= session.createNamedQuery("selectContinent");
        queryFindContinent.setParameter("name", name);
        Continent continent = (Continent) queryFindContinent.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return continent;
    }

    }
