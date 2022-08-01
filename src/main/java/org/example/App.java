package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entity.Detail;
import org.example.entity.Employee;
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
        Employee employee = new Employee("Faina", "Tarasova", "IT Department", 900, detail);
        detail.setEmployee(employee);
        RepositoryService repositoryService = new RepositoryService(sessionFactory);
        repositoryService.addEmployee(employee);
    }
}
