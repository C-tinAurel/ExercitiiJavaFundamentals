
package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Author;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDAO {

    public void insert(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    public List<Author> findAuthorByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindAuthorByName = session.createNamedQuery("findAuthorByName");
        queryFindAuthorByName.setParameter("name", name);
        List<Author> authorList = queryFindAuthorByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return authorList;

    }

    public Integer deleteAuthorByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteAuthorByName = session.createNamedQuery("DeleteAuthorByName");
        queryDeleteAuthorByName.setParameter("name", name);
        Integer deleteAuthorByName=queryDeleteAuthorByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return  deleteAuthorByName;
    }

    public Integer updateAuthorSurname(String name, String surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateAuthorSurname = session.createNamedQuery("UpdateSurnameAuthor");
        queryUpdateAuthorSurname.setParameter("surname", surname);
        queryUpdateAuthorSurname.setParameter("name", name);
        Integer updateAuthorSurname= queryUpdateAuthorSurname.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updateAuthorSurname;
    }

}
