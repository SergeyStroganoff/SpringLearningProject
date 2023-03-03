package org.example.entities;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO implements Serializable {

    private String departmentName;
    private int minSalary;
    private int maxSalary;
}
