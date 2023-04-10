package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.IntroPane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class IntroScene extends Scene {
    public IntroScene() {
        super(new IntroPane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
