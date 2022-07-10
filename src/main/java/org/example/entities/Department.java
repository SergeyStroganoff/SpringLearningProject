package org.example.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Department {
    private String id;
    private String departmentName;
    private int employeeCount;
    private List<User> employeeList;

    public Department(String id, String departmentName, int employeeCount, List<User> employeeList) {
        this.id = id;
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
        this.employeeList = employeeList;
    }

    public Department() {
    }

    public List<User> getEmployeeList() {
        return employeeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }

    public boolean addUser(User user) {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(user);
        return true;
    }

    public boolean deleteUser(User user) {
        int i = 6/0;
        return employeeList.remove(user);
    }
}
