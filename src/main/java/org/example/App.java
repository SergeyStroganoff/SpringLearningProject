package org.example;

import org.example.configuration.ConfigurationSpring;
import org.example.entities.EmployeeDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
        Communication communication = context.getBean("communication", Communication.class);
       List<EmployeeDTO> employeeDTOList =  communication.getAllEmployees();
       employeeDTOList.forEach(System.out::println);
    }
}
