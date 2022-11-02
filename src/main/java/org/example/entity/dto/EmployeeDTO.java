package org.example.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private String name;
    private String surname;
    private int salary;
    private DetailDTO employeeDetail;
    private DepartmentDTO department;
    private transient List<SkillDTO> skillList;
}
