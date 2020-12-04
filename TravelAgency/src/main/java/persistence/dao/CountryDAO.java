package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Country;
import org.hibernate.query.Query;

import java.util.List;

@Repository
public class CountryDAO {


    public void insertCountry(Country country){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
        session.close();

    }

    public Country findCountry(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findCountry=session.createNamedQuery("selectCountry");
        findCountry.setParameter("name",name);
        Country country=(Country) findCountry.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return country;
    }
}
