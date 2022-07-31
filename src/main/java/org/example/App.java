package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entity.Detail;
import org.example.entity.Employee;
import org.example.service.RepositoryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Detail detail = new Detail("Tver", "89157000986", "korida@yandex.ru");
        Employee employee = new Employee("Elena", "Tarasova", "IT Department", 900, detail);
        RepositoryService repositoryService = new RepositoryService(sessionFactory);
        repositoryService.addEmployee(employee);

        // List<Employee> employeeList = repositoryService.getEmployeesByName("Elena");
        // employeeList.forEach(System.out::println);
        // repositoryService.updateEmploee(employee,4);
        //repositoryService.deleteEmploeesById(4);

    }
}
