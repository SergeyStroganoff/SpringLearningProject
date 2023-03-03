package org.example.service;

import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.exceptions.NoSuchEmployeeException;

import java.util.List;

public interface RepositoryService {

    List<EmployeeDTO> getAllEmployees();

    long saveOrUpdate(EmployeeDTO employee);

    boolean deleteEmployee(long employeeId);

    EmployeeDTO getEmployeeDTO (long id) throws NoSuchEmployeeException;

    List<DepartmentDTO> getAllDepartments();
}
