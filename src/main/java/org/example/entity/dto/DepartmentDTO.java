package org.example.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Employee;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {

    private String departmentName;
    private int minSalary;
    private int maxSalary;
   // private transient List<EmployeeDTO> employeeList;
}
