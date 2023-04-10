package com.danke.xtendedsurvival.Monsters;

import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;

public class Slime extends Enemies {
    public Slime() {
        super(20, 20, 2, 2);
        setImage(new Image(getClass().getResourceAsStream("/slime2.png")));
    }
}
