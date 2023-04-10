package com.danke.xtendedsurvival.panes;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SettingsContainer extends Pane {

    public SettingsContainer() {

        // Background
        Image background = new Image(getClass().getResourceAsStream("/sprite_northWindShrineBG.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        // Display Pause Pane without game paused animation
        PausePane pausePane = new PausePane();
        pausePane.pauseOn();
        pausePane.settings();
        this.getChildren().add(pausePane);
    }
}
