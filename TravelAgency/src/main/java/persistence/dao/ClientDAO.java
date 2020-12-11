package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Client;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ClientDAO {

    public void insertClient(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
    }

    public Client findClient(String name, String surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        org.hibernate.query.Query findClient = session.createNamedQuery("selectClient");
        findClient.setParameter("name", name);
        findClient.setParameter("surname", surname);
        Client client = (Client) findClient.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return client;
    }

    public Integer updateClientAddress(String address, String name, String surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateClientAddress=session.createNamedQuery("updateAddress");
        updateClientAddress.setParameter("address",address);
        updateClientAddress.setParameter("name",name);
        updateClientAddress.setParameter("surname",surname);
        Integer updatedRow=updateClientAddress.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }
    public Integer updateClientPhone(int phoneNumber,String name,String surname){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateClientPhone=session.createNamedQuery("updatePhoneNumber");
        updateClientPhone.setParameter("phoneNumber",phoneNumber);
        updateClientPhone.setParameter("name",name);
        updateClientPhone.setParameter("surname",surname);
        Integer updatedRow=updateClientPhone.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return updatedRow;
    }

    public Integer deleteClient(String name,String surname){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteClient=session.createNamedQuery("deleteClient");
        deleteClient.setParameter("name",name);
        deleteClient.setParameter("surname",surname);
        Integer deletedRow=deleteClient.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return deletedRow;
    }
}
