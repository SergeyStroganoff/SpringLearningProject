package org.example.configuration;

import org.example.entities.Cat;
import org.example.entities.Dog;
import org.example.entities.Person;
import org.example.entities.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("org.example") - second way without componentScan
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    @Scope("singleton")
    public Pet dogBean() {
        return new Dog();
    }

    @Bean
    public Person myPerson() {
        return new Person(catBean());
    }
}
