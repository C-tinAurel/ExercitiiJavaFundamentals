package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Book;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAO {

    public void insert(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> findBookByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindBookByTitle = session.createNamedQuery("FindBookByTitle");
        queryFindBookByTitle.setParameter("title", title);
        List<Book> bookList = queryFindBookByTitle.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;

    }

    public void deleteBookByVolumNumber(int volumNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteBookByVolumNumber = session.createNamedQuery("DeleteBookByVolumNumber");
        queryDeleteBookByVolumNumber.setParameter("volumNumber", volumNumber);
        queryDeleteBookByVolumNumber.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public Integer updateBookByGender(String gender, String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateBookByGender = session.createNamedQuery("UpdateBookByGender");
        updateBookByGender.setParameter("gender", gender);
        updateBookByGender.setParameter("title", title);
        Integer numberUpdatedBook = updateBookByGender.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberUpdatedBook;
    }
}
