package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "departments")
@Entity
@NoArgsConstructor
@ToString(includeFieldNames = true)
@Getter
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Employee> employeeList;


    public Department(String departmentName, int minSalary, int maxSalary) {
        this.departmentName = departmentName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void addEmployee(Employee employee) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        employee.setDepartment(this);
    }
}
