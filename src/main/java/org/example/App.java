package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entity.Employee;
import org.example.service.RepositoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        Employee employee = new Employee("Elena", "Tarasova", "IT Department", 900);
        RepositoryService repositoryService = new RepositoryService();
        // List<Employee> employeeList = repositoryService.getEmployeesByName("Elena");
        // employeeList.forEach(System.out::println);
        // repositoryService.updateEmploee(employee,4);
        repositoryService.deleteEmploeesById(4);

    }
}
