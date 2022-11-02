package org.example.entity.dto;

import org.example.entity.Employee;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UtilDTO {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static List<EmployeeDTO> transformToDTOEmployeeList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        employeeList.forEach(x -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setName(x.getName());
            employeeDTO.setSurname(x.getSurname());
            employeeDTO.setSalary(x.getSalary());
            //employeeDTO.setDepartment(modelMapper.map(x.getDepartment(), DepartmentDTO.class));
            employeeDTO.setEmployeeDetail(modelMapper.map(x.getEmployeeDetail(), DetailDTO.class));
            employeeDTOList.add(employeeDTO);
        });
        return employeeDTOList;
    }
}
