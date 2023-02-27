package org.example.repository;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction(); //start transaction
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    @Override
   // @Transactional
    public List<Employee> getAllEmployees() {
        Session session = null;
        Transaction transaction;
        List<Employee> employeeList = new ArrayList<>();
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction(); //start transaction
            employeeList = session.createQuery("From Employee", Employee.class).getResultList();
            // NativeQuery<Employee> query = session.createNativeQuery(
            //        "select * from employees", Employee.class);
            //  employeeList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employeeList;
    }

    @Override
    public long saveOrUpdate(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();
        return employee.getId();
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = null;
        Transaction transaction;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Удаление не удалось");
            if (session != null) {
                session.close();
                return false;
            }
        }
        return true;
    }
}
