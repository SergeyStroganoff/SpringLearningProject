package org.example;

import org.example.entities.Dog;
import org.example.entities.Person;
import org.example.entities.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = applicationContext.getBean("myDog", Dog.class);
        Person person = applicationContext.getBean("myPerson", Person.class);
        person.callPet();
        System.out.println(person.getFullName() + "  " + person.getAge());
        applicationContext.close();
    }
}
