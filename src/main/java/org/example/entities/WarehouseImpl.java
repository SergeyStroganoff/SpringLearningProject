package org.example.entities;


import org.springframework.stereotype.Component;

@Component("warehouseImpl")
public class WarehouseImpl implements Warehouse {

    public WarehouseImpl() {
        System.out.println("Created object WareHouse");
    }

    @Override
    public Item getItem(String id) {
        System.out.println("Returned Item");
        return new Item();

    }
}
