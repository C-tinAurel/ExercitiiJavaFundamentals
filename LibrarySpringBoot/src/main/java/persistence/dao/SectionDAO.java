package persistence.dao;
import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entitites.Author;
import persistence.entitites.Section;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
@Repository
public class SectionDAO {

    public void insert(Section section) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        session.close();
    }

    public List<Section> findSectionByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryFindSectionByName = session.createNamedQuery("SelectSectionByName");
        queryFindSectionByName.setParameter("name", name);
        List<Section> sectionList = queryFindSectionByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return sectionList;
    }


    public Integer deleteSectionByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteSectionByName=session.createNamedQuery("DeleteSectionByName");
        queryDeleteSectionByName.setParameter("name",name);
          Integer deleteSectionByNameRow  = queryDeleteSectionByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deleteSectionByNameRow;
    }

    public Integer updateSectionByAuthor(Set<Author> authorSet, String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryUpdateSectionByAuthor=session.createNamedQuery("UpdateSection");
        queryUpdateSectionByAuthor.setParameter("authorSet",authorSet);
        queryUpdateSectionByAuthor.setParameter("name",name);
        Integer updateSectionByAuthorRow=queryUpdateSectionByAuthor.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updateSectionByAuthorRow;
    }
}
