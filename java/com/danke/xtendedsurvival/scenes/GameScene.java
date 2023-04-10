package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.*;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.*;

public class GameScene extends Scene{
    public GameScene() {
        super(new GameContainer(MAIN_PANE, new PausePane()), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
