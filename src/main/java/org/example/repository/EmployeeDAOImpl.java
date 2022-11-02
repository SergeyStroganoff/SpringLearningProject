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
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class,id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("From Employee", Employee.class).getResultList();
        return employeeList;
    }

    @Override
    public long add(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        return employee.getId();
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
        return true;
    }
}
