package com.danke.xtendedsurvival.old;

import com.danke.xtendedsurvival.panes.PausePane;
import com.danke.xtendedsurvival.scenes.OutroScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.*;
import static com.danke.xtendedsurvival.Constants.MANAGER;

public class GameKnightPane extends BorderPane {
    Boolean menuActive = false;

    public GameKnightPane(){
        MANAGER.stopMusic();
        MANAGER.playMusic("gameMusic");

        GaussianBlur blur = new GaussianBlur(10);
        Rectangle blurLayer = new Rectangle(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        this.getChildren().add(blurLayer);
        blurLayer.setEffect(blur);
        blurLayer.setFill(Color.color(0,0,0,0));
        PausePane pausePane = new PausePane();
        this.getChildren().add(pausePane);
        pausePane.setLayoutX(-1000);
        pausePane.setLayoutY(-1000);

        Image background = new Image(getClass().getResourceAsStream("/battleback1.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(SCREEN_WIDTH, SCREEN_HEIGHT,false, false, true, true));

        Image plate = new Image(getClass().getResourceAsStream("/plate.png"));
        ImageView bottomPlate = new ImageView(plate);
        bottomPlate.setFitHeight(250);
        bottomPlate.setFitWidth(1024);
//        BackgroundImage bottomPlate = new BackgroundImage(plate, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(SCREEN_WIDTH, SCREEN_HEIGHT,false, false, true, true));

        Image knight = new Image(getClass().getResourceAsStream("/knight.png"));
        ImageView knightFace = new ImageView(knight);
        knightFace.setFitWidth(150);
        knightFace.setFitHeight(150);

        Text empty =new Text("\n\n");
        Text empty2 =new Text("              ");

        GridPane gridPaneBottom = new GridPane();

        gridPaneBottom.add(bottomPlate, 0, 0, 10, 3);
//        gridPaneBottom.setBackground(new Background(bottomPlate));
        gridPaneBottom.add(empty,0,0);
        gridPaneBottom.add(empty2,0, 1);
        gridPaneBottom.add(knightFace, 1, 1);
        gridPaneBottom.setVgap(2);

        this.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ESCAPE) {
                if (menuActive) {
                    pausePane.pauseOff();
                    menuActive = false;
                } else {
                    pausePane.pauseOn();
                    menuActive = true;
                }
            }
        });

        this.setBottom(gridPaneBottom);
        this.setBackground(new Background(backgroundImage));
    }
}
