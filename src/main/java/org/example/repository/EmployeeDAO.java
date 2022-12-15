package org.example.repository;

import org.example.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeDAO {
    Employee getEmployee(long id);

    List<Employee> getAllEmployees();

    long add(Employee employee);

    boolean delete(Employee employee);
}
