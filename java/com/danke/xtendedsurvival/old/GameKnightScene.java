package com.danke.xtendedsurvival.old;

import com.danke.xtendedsurvival.old.GameKnightPane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class GameKnightScene extends Scene {
    public GameKnightScene(){
        super(new GameKnightPane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
