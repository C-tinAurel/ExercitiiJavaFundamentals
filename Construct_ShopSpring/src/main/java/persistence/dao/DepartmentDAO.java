package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Department;


import org.hibernate.query.Query;


@Repository
public class DepartmentDAO {

    public void insert(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(department);
        session.getTransaction().commit();
        session.close();
    }

    public Department findDepartmentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findDepartmentQuery = session.createNamedQuery("findDepartmentByName");
        findDepartmentQuery.setParameter("name", name);
        Department departmentFoundQuery = (Department) findDepartmentQuery.uniqueResult();
        session.getTransaction().commit();
        session.close();
        Department department = new Department();
        if (departmentFoundQuery == null) {
            department.setName(" ");
            return department;
        } else {
            return departmentFoundQuery;
        }
    }

    public Integer deleteDepartmentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query queryDeleteDepartmentByName = session.createNamedQuery("DeleteDepartmentByName");
        queryDeleteDepartmentByName.setParameter("name", name);
        Integer numberDeletedDepartment = queryDeleteDepartmentByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberDeletedDepartment;
    }
}
