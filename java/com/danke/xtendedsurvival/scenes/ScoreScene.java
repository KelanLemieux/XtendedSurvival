package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.OutroPane;
import com.danke.xtendedsurvival.panes.ScorePane;
import javafx.scene.Scene;
import com.danke.xtendedsurvival.Constants.*;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class ScoreScene extends Scene {
    public ScoreScene() {
        super(new ScorePane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }

}
