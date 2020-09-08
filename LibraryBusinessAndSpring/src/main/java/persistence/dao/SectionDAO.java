package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Section;

import javax.persistence.Query;
import java.util.List;
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
            Query queryfindSectionByName = session.createNamedQuery("FindSectionByName");
            queryfindSectionByName.setParameter("name", name);
            List<Section> sectionList = queryfindSectionByName.getResultList();
            session.getTransaction().commit();
            session.close();
            return sectionList;
        }

        public void deleteSectionByName(String name) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query queryDeleteSectionByName = session.createNamedQuery("DeleteSectionByName");
            queryDeleteSectionByName.setParameter("name", name);
            queryDeleteSectionByName.executeUpdate();
            session.getTransaction().commit();
            session.close();

        }
    }
