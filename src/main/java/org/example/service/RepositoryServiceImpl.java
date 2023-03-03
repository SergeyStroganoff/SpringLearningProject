package org.example.service;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.entity.dto.UtilDTO;
import org.example.exceptions.NoSuchEmployeeException;
import org.example.repository.DepartmentDAO;
import org.example.repository.EmployeeDAO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class RepositoryServiceImpl implements RepositoryService {

    public static final String NO_EMPLOYEE_WITH_SUCH_ID = "No Employee with such id";
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        // return modelMapper.map(employees, new TypeToken<List<EmployeeDTO>>() {
        //  }.getType());
        return UtilDTO.transformToDTOEmployeeList(employees);
    }
    @Override
    public long saveOrUpdate(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        return employeeDAO.saveOrUpdate(employee);
    }

    @Override
    public boolean deleteEmployee(long employeeId) {
        Employee employee = employeeDAO.getEmployee(employeeId);
        return employeeDAO.delete(employee);
    }

    @Override
    public EmployeeDTO getEmployeeDTO(long id) throws NoSuchEmployeeException {
        Employee employee = employeeDAO.getEmployee(id);
        if (employee == null) {
            throw  new NoSuchEmployeeException(NO_EMPLOYEE_WITH_SUCH_ID + " " + id);
        }
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentDTOList = departmentDAO.getAllDepartments();
        return modelMapper.map(departmentDTOList, new TypeToken<List<DepartmentDTO>>() {
        }.getType());
    }
}