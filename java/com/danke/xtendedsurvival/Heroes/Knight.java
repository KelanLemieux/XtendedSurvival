package com.danke.xtendedsurvival.Heroes;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.panes.EnemyPane;
import javafx.scene.image.Image;

import java.util.ArrayList;

import static com.danke.xtendedsurvival.Constants.*;

public class Knight extends Characters {

    Image skin = new Image("/knight.png");
    public Knight() {
        super(new ArrayList<>(), 100, 10000, 100, 10, 0);
        this.setSkin(skin);
    }

    public void defend(EnemyPane enemy){
        enemy.getEnemy().getStrength();
    }
}
