package org.example.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SkillDTO implements Serializable {
   private String skillName;
   private transient List<EmployeeDTO> employeeList;
}
