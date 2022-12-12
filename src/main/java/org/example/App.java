package org.example;

import org.example.entities.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = applicationContext.getBean("myPerson", Person.class);
        person.callPet();
        System.out.println(person.getFullName() + "  " + person.getAge());
        applicationContext.close();
    }
}
