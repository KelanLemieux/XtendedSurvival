package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.ControlsPane;
import com.danke.xtendedsurvival.panes.IntroPane;
import com.danke.xtendedsurvival.panes.MenuPane;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;


public class MenuScene extends Scene {
    public MenuScene() {
        super(new MenuPane(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
