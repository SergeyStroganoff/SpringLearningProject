package org.example.entities;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable {

    private long id;
    private String name;
    private String surname;
    private int salary;
    private DetailDTO employeeDetail;
    private DepartmentDTO department;
    private final transient List<SkillDTO> skillList = new ArrayList<>();

    public void addSkill(SkillDTO skill) {
        skillList.add(skill);
    }
}
