package org.example.service;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.entity.dto.UtilDTO;
import org.example.repository.DepartmentDAO;
import org.example.repository.EmployeeDAO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class RepositoryServiceImpl implements RepositoryService {
    private final DepartmentDAO departmentDAO;
    private final EmployeeDAO employeeDAO;
    private final ModelMapper modelMapper;

    public RepositoryServiceImpl(DepartmentDAO departmentDAO, EmployeeDAO employeeDAO, ModelMapper modelMapper) {
        this.departmentDAO = departmentDAO;
        this.employeeDAO = employeeDAO;
        this.modelMapper = modelMapper;
    }

    @Autowired


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        // return modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>() {
        //  }.getType());
        return UtilDTO.transformToDTOEmployeeList(employees);
    }

    @Override
    public long add(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        return employeeDAO.add(employee);
    }

    @Override
    public boolean delete(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        return employeeDAO.delete(employee);
    }

    @Override
    public EmployeeDTO getEmployeeDTO(long id) {
        Employee employee = employeeDAO.getEmployee(id);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentDTOList = departmentDAO.getAllDepartments();
        return modelMapper.map(departmentDTOList, new TypeToken<List<DepartmentDTO>>() {
        }.getType());
    }
}
