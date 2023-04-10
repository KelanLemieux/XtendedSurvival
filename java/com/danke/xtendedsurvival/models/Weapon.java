package com.danke.xtendedsurvival.models;

public abstract class Weapon extends Item {

    int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Weapon(String name, int quantity, int damage) {
        super(name, quantity);
        this.damage = damage;
    }

    public abstract void attack(Characters c);

}
