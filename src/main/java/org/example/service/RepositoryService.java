package org.example.service;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RepositoryService {

    @Autowired
    private SessionFactory sessionFactory;


    protected Session getSession() {
        if (sessionFactory==null){
            System.out.println("SessionFAcroty is null !!! Error");
        }
        return this.sessionFactory.getCurrentSession();
    }


    public long addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        return employee.getId();
    }

    public Employee getEmployeeById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee fromDB = session.get(Employee.class, id);
        session.getTransaction().commit();
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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employeeList = session.createQuery("From Employee where name=name").getResultList();
        session.getTransaction().commit();
        return employeeList;
    }

    public void updateEmploee(Employee employee, long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employeeFromDB = session.get(Employee.class, id);
        employeeFromDB.setName(employee.getName());
        employeeFromDB.setSurname(employee.getSurname());
        employeeFromDB.setDepartment(employee.getDepartment());
        employeeFromDB.setSalary(employee.getSalary());
        session.getTransaction().commit();
    }

    public void updateSalaryEmploeesById(int newSalary, long newId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("update Employee set salary=:newSalary where id=:newId");
        query.setParameter("newSalary", newSalary);
        query.setParameter("newId", newId);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void deleteEmploeesById(long id) {
        Session session = getSession();
        session.beginTransaction();
        // Employee employee = session.get(Employee.class, id);
        // session.delete(employee);
        Query query = session.createQuery("delete Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
