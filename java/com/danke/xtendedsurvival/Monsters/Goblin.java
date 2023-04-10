package com.danke.xtendedsurvival.Monsters;

import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;

public class Goblin extends Enemies {
    public Goblin() {
        super(40, 40,4, 4);
        setImage(new Image(getClass().getResourceAsStream("/goblin.png")));
    }

}
