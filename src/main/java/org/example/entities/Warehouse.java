package org.example.entities;

import org.springframework.stereotype.Component;

@Component
public interface Warehouse {
    Item getItem(String id);
}
