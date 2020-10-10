package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import persistence.entities.Departament;

import javax.persistence.Query;
import java.util.List;

public class DepartamentDAO {

    public void insert(Departament departament){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(departament);
        session.getTransaction().commit();
        session.close();
    }
public List<Departament> findDepartamentByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    Query queryFindDepartamentByName=session.createNamedQuery("findDepartamentByName");
    queryFindDepartamentByName.setParameter("name",name);
    List<Departament> departamentList=queryFindDepartamentByName.getResultList();
    session.getTransaction().commit();
    session.close();
    return departamentList;
}
}
