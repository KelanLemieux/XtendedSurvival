package com.danke.xtendedsurvival.items.potions;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Item;

public class StrengthPotion extends Item {

    int strengthBoost;

    public StrengthPotion(String name, int quantity, int strengthBoost) {
        super(name, quantity);
        this.strengthBoost = strengthBoost;
    }

    public void use(Characters c){
        //TODO Figure out how long the strength potions will last and how to implement
        c.setStrength(c.getStrength()+10);
    }
}
