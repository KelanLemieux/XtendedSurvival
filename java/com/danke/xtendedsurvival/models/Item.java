package com.danke.xtendedsurvival.models;

public class Item {

    String name;
    int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}
