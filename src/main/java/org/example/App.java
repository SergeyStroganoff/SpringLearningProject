package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entity.Department;
import org.example.entity.Detail;
import org.example.entity.Employee;
import org.example.entity.Skill;
import org.example.service.RepositoryService;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring and Hibernate Learning project!
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Detail detail = new Detail("Moscow", "89157000986", "korida@yandex.ru");
        Department department = new Department("ItDepartment", 1000, 1800);
        Skill skillJava = new Skill("Java");
        Skill HTML = new Skill("HTML");
        Employee employee = new Employee("Faina", "Tarasova", 900, detail);
        employee.setDepartment(department);
        employee.addSkill(skillJava, HTML);
        RepositoryService repositoryService = new RepositoryService(sessionFactory);
        long id = repositoryService.addEmployee(employee);
        System.out.println("We added new employee, his id = " + id);
    }
}
