package org.example.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Skill;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    @Size(min = 2, max = 12, message = "Name must be from 2 to 12 symbols")
    private String name;
    private String surname;
    private int salary;
    private DetailDTO employeeDetail;
    private DepartmentDTO department;
    private transient List<SkillDTO> skillList;

    public void addSkill(SkillDTO skill){
        if (skill==null) {
            skillList = new ArrayList<>();
        }
        skillList.add(skill);
    }
}
