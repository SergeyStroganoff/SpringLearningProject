package org.example.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id") // name of foreign key in table Employee linked to id of details tables.
    private Detail employeeDetail;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "department_id") //foreign key is always here.
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "employee_skils",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")) // join table for foreign keys !!!
    @ToString.Exclude
    private List<Skill> skillList;

    public Employee(String name, String surname, int salary, Detail employeeDetail) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.employeeDetail = employeeDetail;
    }

    public void addSkill(Skill... skill) {
        if (skillList == null) {
            skillList = new ArrayList<>();
        }

        skillList.addAll(List.of(skill));
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (department.getEmployeeList() == null || !department.getEmployeeList().contains(this)) {
            department.addEmployee(this);
        }
    }

    public void addEmployeeDetail(Detail detail) {
        employeeDetail = detail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
