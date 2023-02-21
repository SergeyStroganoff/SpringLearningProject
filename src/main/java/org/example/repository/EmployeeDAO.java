package org.example.repository;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    long saveOrUpdate(Employee employee);

    boolean delete(Employee employee);
}
