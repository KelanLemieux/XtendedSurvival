package com.danke.xtendedsurvival.panes;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;

import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class GameContainer extends Pane {
    private GaussianBlur blur = new GaussianBlur(30);
    private boolean paused = false;

    public GameContainer(MainPane mp, PausePane p) {
        // Add mainpane and pausepane
        this.getChildren().addAll(mp, p);

        // Set Pane Positions
        p.pauseOff();

        // Manage Inputs
        this.setFocusTraversable(true);
        this.requestFocus();
        this.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ESCAPE) {
                if (paused) {
                    p.pauseOff();
                    paused = false;
                    mp.setEffect(null);
                } else {
                    p.pauseOn();
                    paused = true;
                    mp.setEffect(blur);
                }
            }
        });

    }

}
