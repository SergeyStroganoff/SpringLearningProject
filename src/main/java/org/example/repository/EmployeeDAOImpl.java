package org.example.repository;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction(); //start transaction
        List<Employee> employeeList = session.createQuery("From Employee", Employee.class).getResultList();
        session.close();
        return employeeList;
    }

    @Override
    public long add(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.close();
        return employee.getId();
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(employee);
        session.close();
        return true;
    }
}
