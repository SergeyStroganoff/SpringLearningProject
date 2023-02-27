package org.example.service;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.List;

//@Repository
public class OldService {

    public OldService() {
    }
    @Autowired
    private SessionFactory sessionFactory;

    public OldService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long addEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(employee);   // also, we can use persist
            session.getTransaction().commit();
            return employee.getId();
        }
    }

    public Employee getEmployeeById(long id) {
        Employee fromDB;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            fromDB = session.get(Employee.class, id);
            session.getTransaction().commit();
        }
        return fromDB;
    }

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employeeList = session.createQuery("From Employee").getResultList();
        session.getTransaction().commit();
        return employeeList;
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> employeeList;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("From Employee where name=:name");
            query.setParameter("name", name);
            employeeList = query.getResultList();
            session.getTransaction().commit();
        }
        return employeeList;
    }

    public void updateEmployee(Employee employee, long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employeeFromDB = session.get(Employee.class, id);
        employeeFromDB.setName(employee.getName());
        employeeFromDB.setSurname(employee.getSurname());
        employeeFromDB.addDepartment(employee.getDepartment());
        employeeFromDB.setSalary(employee.getSalary());
        session.getTransaction().commit();
    }

    public void updateSalaryEmploeesById(int newSalary, long newId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Employee set salary=:newSalary where id=:newId");
        query.setParameter("newSalary", newSalary);
        query.setParameter("newId", newId);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void deleteEmployesById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            // Employee employee = session.get(Employee.class, id);
            // session.delete(employee);
            Query query = session.createQuery("delete Employee where id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public int addDepartment(Department department) {
        int id = 0;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            id = (int) session.save(department);
            session.getTransaction().commit();
        }
        return id;
    }
}
