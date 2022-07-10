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

    @Override
    public String addItem(Item item) {
        String id = "10";
        System.out.println(item.toString() + " added");
        return id;
    }

    @Override
    public String changeItem(Item item) {
        String id = "10";
        return id;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }


}
