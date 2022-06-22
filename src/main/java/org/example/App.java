package org.example;

import org.example.configuration.MyConfig;
import org.example.entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = annotationConfigApplicationContext.getBean("myPerson", Person.class);
        person.callPet();
        System.out.println(person.getFullName() + "  " + person.getAge());
        annotationConfigApplicationContext.close();
    }
}
