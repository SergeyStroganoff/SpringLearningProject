package org.example.entity.dto;

import lombok.*;
import org.example.entity.Employee;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO implements Serializable {

    private String departmentName;
    private int minSalary;
    private int maxSalary;
   // private transient List<EmployeeDTO> employeeList;
}
