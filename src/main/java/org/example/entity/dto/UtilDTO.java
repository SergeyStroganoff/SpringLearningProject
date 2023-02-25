package org.example.entity.dto;

import org.example.entity.Department;
import org.example.entity.Detail;
import org.example.entity.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class UtilDTO {
    private UtilDTO() {
    }
    private static final ModelMapper modelMapper = new ModelMapper();

    public static List<EmployeeDTO> transformToDTOEmployeeList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (!employeeList.isEmpty()) {
            employeeList.forEach(x -> {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setName(x.getName());
                employeeDTO.setSurname(x.getSurname());
                employeeDTO.setSalary(x.getSalary());
                if (x.getDepartment() != null) {
                    employeeDTO.setDepartment(modelMapper.map(x.getDepartment(), DepartmentDTO.class));
                }
                if (x.getEmployeeDetail() != null) {
                    employeeDTO.setEmployeeDetail(modelMapper.map(x.getEmployeeDetail(), DetailDTO.class));
                }
                employeeDTOList.add(employeeDTO);
            });
        }
        return employeeDTOList;
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setSalary(employeeDTO.getSalary());
        employee.addDepartment(modelMapper.map(employeeDTO.getDepartment(), Department.class));
        employee.setEmployeeDetail(modelMapper.map(employeeDTO.getEmployeeDetail(), Detail.class));
        employee.setSkillList(modelMapper.map(employeeDTO.getSkillList(), new TypeToken<List<EmployeeDTO>>() {
        }.getType()));
        return employee;
    }
}
