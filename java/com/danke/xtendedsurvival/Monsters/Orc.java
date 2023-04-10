package com.danke.xtendedsurvival.Monsters;

import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;

public class Orc extends Enemies {
    public Orc() {
        super(50, 50,5, 5);
        setImage(new Image(getClass().getResourceAsStream("/orc.png")));
    }

}
