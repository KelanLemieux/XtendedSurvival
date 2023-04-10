package com.danke.xtendedsurvival.items.potions;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Item;

public class ManaPotion extends Item {

    int manaBoost;

    public ManaPotion(String name, int quantity, int manaBoost) {
        super(name, quantity);
        this.manaBoost = manaBoost;
    }

    public int getManaBoost() {
        return manaBoost;
    }

    public void setManaBoost(int manaBoost) {
        this.manaBoost = manaBoost;
    }

    public void use(Characters c){
        c.setHealth(Math.max(c.getMana()+manaBoost, c.getMaxMana()));
    }
}
