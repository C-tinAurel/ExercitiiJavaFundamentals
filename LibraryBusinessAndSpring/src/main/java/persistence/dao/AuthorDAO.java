package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Author;
import persistence.entities.Section;

import javax.persistence.Query;
import java.util.List;
@Repository
public class AuthorDAO {


    public void insert(Author author){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
    public List<Author> findAuthorByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindAuthorByName=session.createNamedQuery("SelectAuthorByName");
        queryFindAuthorByName.setParameter("name",name);
        List<Author> authorList=queryFindAuthorByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return authorList;

    }
    public void deleteAuthorBySurname(String surname){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteAuthorBySurname=session.createNamedQuery("DeleteAuthorBySurname");
        queryDeleteAuthorBySurname.setParameter("surname",surname);
        queryDeleteAuthorBySurname.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
