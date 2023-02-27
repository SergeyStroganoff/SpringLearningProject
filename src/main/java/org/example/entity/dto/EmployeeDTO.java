package org.example.entity.dto;

import lombok.*;

import javax.validation.constraints.Size;
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
    @Size(min = 2, max = 12, message = "Name must be from 2 to 12 symbols")
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
