package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.IntroPane;
import com.danke.xtendedsurvival.panes.OutroPane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class OutroScene extends Scene {
    public OutroScene() {
        super(new OutroPane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
