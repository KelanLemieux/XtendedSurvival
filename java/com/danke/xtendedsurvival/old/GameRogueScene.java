package com.danke.xtendedsurvival.old;


import com.danke.xtendedsurvival.old.GameRoguePane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class GameRogueScene extends Scene {
    public GameRogueScene(){
        super(new GameRoguePane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
