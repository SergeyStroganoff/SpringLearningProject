package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entity.Employee;
import org.example.service.RepositoryService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    ;

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        try (SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory()) {
            Employee employee = new Employee("Elena", "Tarasova", "IT Department", 900);
            RepositoryService repositoryService = new RepositoryService(sessionFactory);
            List<Employee> employeeList = repositoryService.getEmployeesByName("Elena");
            employeeList.forEach(System.out::println);
            // repositoryService.updateEmploee(employee,4);
            repositoryService.deleteEmploeesById(4);
        }
    }
}
