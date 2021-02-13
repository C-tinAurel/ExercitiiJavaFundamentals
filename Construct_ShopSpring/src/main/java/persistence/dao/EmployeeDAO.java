package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Employee;

import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAO {

    public void insertEmployee(Employee employee){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
    public List<Employee> findEmployeeByName(String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findEmployeeByName=session.createNamedQuery("SelectEmployeeByName");
        findEmployeeByName.setParameter("name",name);
        List<Employee> employeeList=findEmployeeByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return employeeList;
    }
    public Integer deleteEmployeeByAge(int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteEmployeeByAge=session.createNamedQuery("DeleteEmployeeByAge");
        deleteEmployeeByAge.setParameter("age",age);
        Integer numberOfDeletedEmployee=deleteEmployeeByAge.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfDeletedEmployee;
    }
    public Integer updateEmployeeSurname(String surname,String name){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateEmployeeSurname=session.createNamedQuery("UpdateEmployeeSurname");
        updateEmployeeSurname.setParameter("surname",surname);
        updateEmployeeSurname.setParameter("name",name);
        Integer numberOfUpdatedEmployee=updateEmployeeSurname.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfUpdatedEmployee;
    }
}
