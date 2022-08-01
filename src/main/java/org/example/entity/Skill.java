package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
@NoArgsConstructor
@Getter
@ToString(includeFieldNames = true)
public class Skill {

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "skill_name")
    @Setter
    String skillName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "employee_skils",
            joinColumns = @JoinColumn(name = "skills_id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id")) // join table for foreign keys !!!
    @ToString.Exclude
    @Setter
    List<Employee> employeeList;

    public void addEmployee(Employee employee) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
    }
}
