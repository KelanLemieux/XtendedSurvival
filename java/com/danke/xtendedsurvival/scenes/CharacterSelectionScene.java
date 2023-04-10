package com.danke.xtendedsurvival.scenes;

import com.danke.xtendedsurvival.panes.CharacterSelectionPane2;
import javafx.scene.Scene;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class CharacterSelectionScene extends Scene {
    public CharacterSelectionScene() {
        super(new CharacterSelectionPane2(), SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
