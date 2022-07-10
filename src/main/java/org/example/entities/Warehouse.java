package org.example.entities;

import org.springframework.stereotype.Component;

@Component
public interface Warehouse {
    Item getItem(String id);

    String addItem(Item item);

    String changeItem(Item item);

    boolean deleteItem(String Id);
}
