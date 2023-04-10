package com.danke.xtendedsurvival.Heroes;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Item;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Mage extends Characters {
    Image skin = new Image("/knight.png");
    public Mage() {
        super(new ArrayList<>(), 80, 2, 80, 5, 0);
        this.setSkin(skin);
    }
}
