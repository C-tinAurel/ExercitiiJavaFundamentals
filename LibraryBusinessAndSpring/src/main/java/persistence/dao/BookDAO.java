package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Book;

import javax.persistence.Query;
import java.util.List;
@Repository
public class BookDAO {

    public void insert(Book book){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> findTitleBook(String title){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryTitleBook=session.createNamedQuery("FindTitleBook");
        queryTitleBook.setParameter("title",title);
        List<Book> bookList=queryTitleBook.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }
    public void deleteBookByVolumNumber(int volumNumber){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteByVolumNumber=session.createNamedQuery("DeleteByVolumNumber");
        queryDeleteByVolumNumber.setParameter("volumNumber",volumNumber);
        queryDeleteByVolumNumber.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
