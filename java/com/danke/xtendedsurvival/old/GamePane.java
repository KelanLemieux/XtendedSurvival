package com.danke.xtendedsurvival.old;

import com.danke.xtendedsurvival.panes.PausePane;
import javafx.geometry.Insets;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.danke.xtendedsurvival.Constants.*;

public class GamePane extends Pane {
    Boolean menuActive = false;
    public GamePane() {
        // Play music, set volume
        MANAGER.stopMusic();
        MANAGER.playMusic("gameMusic");
        // Get skin
        Image character = player.getSkin();
        // Create Character
        ImageView iv = new ImageView(character);
        this.getChildren().addAll(iv);
        // Background
        Background bg = new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        this.setBackground(bg);
        iv.setFocusTraversable(true);
        iv.setX(SCREEN_WIDTH / 2);
        iv.setY(SCREEN_HEIGHT / 2);
        iv.requestFocus();
        // Pause Menu
        GaussianBlur blur = new GaussianBlur(10);
        Rectangle blurLayer = new Rectangle(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        this.getChildren().add(blurLayer);
        blurLayer.setEffect(blur);
        blurLayer.setFill(Color.color(0,0,0,0));
        PausePane pausePane = new PausePane();
        this.getChildren().add(pausePane);
        pausePane.setLayoutX(-1000);
        pausePane.setLayoutY(-1000);

        // handle key input
        this.setOnKeyPressed(e -> {
            if ((e.getCode() == KeyCode.W && iv.getY() > 0 || e.getCode() == KeyCode.UP && iv.getY() > 0) && !menuActive) {
                iv.setY(iv.getY() - 10);
            } else if ((e.getCode() == KeyCode.S && iv.getY() < SCREEN_HEIGHT-40 || e.getCode() == KeyCode.DOWN && iv.getY() < SCREEN_HEIGHT-40) && !menuActive) {
                iv.setY(iv.getY() + 10);
            } else if ((e.getCode() == KeyCode.A && iv.getX() > 0 || e.getCode() == KeyCode.LEFT && iv.getX() > 0) && !menuActive) {
                iv.setX(iv.getX() - 10);
            } else if ((e.getCode() == KeyCode.D && iv.getX() < SCREEN_WIDTH-40 || e.getCode() == KeyCode.RIGHT && iv.getX() < SCREEN_WIDTH-40) && !menuActive) {
                iv.setX(iv.getX() + 10);
              // pause menu
            } else if (e.getCode() == KeyCode.ESCAPE){
                if(menuActive){
                    pausePane.setLayoutY(-1000);
                    pausePane.setLayoutX(-1000);
                    menuActive = false;
                } else {
                    pausePane.setLayoutX((SCREEN_WIDTH/2) - (pausePane.getWidth()/2));
                    pausePane.setLayoutY((SCREEN_HEIGHT/2) - (pausePane.getHeight()/2));
                    menuActive = true;
                }
            }
        });
    }
}
