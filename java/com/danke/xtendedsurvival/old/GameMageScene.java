package com.danke.xtendedsurvival.old;

import com.danke.xtendedsurvival.old.GameMagePane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class GameMageScene extends Scene {
    public GameMageScene(){
        super(new GameMagePane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
