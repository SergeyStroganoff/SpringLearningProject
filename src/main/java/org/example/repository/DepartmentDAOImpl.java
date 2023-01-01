package org.example.repository;

import org.example.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Department> departments = session.createQuery("From Department ", Department.class).getResultList();
        session.close();
        return departments;
    }
}

