package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    // name of foreign key in table Employee linked to id of details tables.
    private Detail employeeDetail;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
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

    public void addSkill(Skill skill) {
        if (skillList == null) {
            skillList = new ArrayList<>();
        }
        skillList.add(skill);
        skill.addEmployee(this);

    }

    public void setDepartment(Department department) {
        this.department = department;
        if (department.getEmployeeList() == null || !department.getEmployeeList().contains(this)) {
            department.addEmployee(this);
        }
    }

    public void setEmployeeDetail(Detail detail) {
        employeeDetail = detail;
        detail.setEmployee(this);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", employeeDetail=" + employeeDetail.getCity() +
                ", department=" + department.getDepartmentName() +
                ", skillList=" + skillList.get(0).getSkillName() +
                '}';
    }
}
