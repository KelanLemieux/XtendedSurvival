package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.IntroPane;
import com.danke.xtendedsurvival.panes.OutroPane;
import com.danke.xtendedsurvival.panes.SettingsContainer;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class SettingsScene extends Scene {
    public SettingsScene() {
        super(new SettingsContainer(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
