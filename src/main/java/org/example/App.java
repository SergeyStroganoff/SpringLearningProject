package org.example;

import org.example.configuration.ConfigurationSpring;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);
    }
}
