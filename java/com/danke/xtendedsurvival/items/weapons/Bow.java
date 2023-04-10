package com.danke.xtendedsurvival.items.weapons;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Weapon;

public class Bow extends Weapon {

    public Bow(String name, int quantity, int damage) {
        super(name, quantity, damage);
    }

    @Override
    public void attack(Characters c) {
        c.setHealth(Math.min(c.getHealth()-this.getDamage(), 0));
    }

    public void shoot(){
        //TODO shoot projectiles with bow
    }
}
