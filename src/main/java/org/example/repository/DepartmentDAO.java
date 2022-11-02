package org.example.repository;

import org.example.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getAllDepartments();
}
