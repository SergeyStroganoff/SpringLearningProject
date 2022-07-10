package org.example;

import org.example.configuration.MainConfig;
import org.example.entities.*;
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
        Item item = applicationContext.getBean("item", Item.class);
        item.setName("Table");
        warehouse.addItem(item);

        User user = applicationContext.getBean("user", User.class);
        user.setFullName("Ivanov Anton Pavlovich");
        user.setId("001");
        user.setRole("Administrator");

        Department department = (Department) applicationContext.getBean("department", "123", "ItDepartment", 5);
        department.addUser(user);
        department.deleteUser(null);
        applicationContext.close();
    }
}
