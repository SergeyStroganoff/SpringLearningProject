package org.example.service;

import org.example.entity.Department;
import org.example.entity.Detail;
import org.example.entity.Employee;
import org.example.entity.Skill;
import org.example.entity.dto.DepartmentDTO;
import org.example.entity.dto.EmployeeDTO;
import org.example.entity.dto.UtilDTO;
import org.example.repository.DepartmentDAO;
import org.example.repository.EmployeeDAO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class RepositoryServiceImpl implements RepositoryService {

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
        Department department = new Department("Finance", 1000, 5000);
        Detail detail = new Detail();
        detail.setCity("Ivanovo");
        detail.setEmail("111@set.com");
        detail.setPhoneNumber("1234567890");

        Skill skill = new Skill();
        skill.setSkillName("Ajhntgzyj");

        Employee employee2 = new Employee();
        employee2.setName("Inan");
        employee2.setSalary(3453);
        employee2.setSurname("Gavri");
        employee2.addEmployeeDetail(detail);
        employee2.addDepartment(department);
        employee2.addSkill(skill);
        System.out.println(department);
        System.out.println(detail);
        System.out.println(skill);
        System.out.println(employee2);
        return employeeDAO.saveOrUpdate(employee2);
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
