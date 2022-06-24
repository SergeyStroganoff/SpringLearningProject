package org.example;

import org.example.configuration.MainConfig;
import org.example.entities.Warehouse;
import org.example.entities.WarehouseImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        Warehouse warehouse = applicationContext.getBean("warehouseImpl", WarehouseImpl.class);
        warehouse.getItem("12");
        applicationContext.close();
    }
}
