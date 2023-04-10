package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.AudioManager;
import com.danke.xtendedsurvival.scenes.CharacterSelectionScene;
import com.danke.xtendedsurvival.scenes.MenuScene;
import com.danke.xtendedsurvival.scenes.SettingsScene;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.MANAGER;

public class IntroPane extends BorderPane {

    public IntroPane(){

        // Audio
        if (!MANAGER.alreadyPlaying("introMusic")) {
            MANAGER.playMusic("introMusic");
        }
        HBox gameTitleBox = new HBox();
        VBox positioning = new VBox();

        // background image
        Image background = new Image(getClass().getResourceAsStream("/sprite_northWindShrineBG.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        // Fonts
        InputStream inputStreamFont = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStreamFont, 60);
        InputStream inputStreamFont2 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font2 = Font.loadFont(inputStreamFont2, 30);
        InputStream inputStreamFont3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font3 = Font.loadFont(inputStreamFont3, 200);

        Text presentation = new Text("\n-DanKe\u2122 presents");
        presentation.setFont(font2);
        presentation.setStroke(Color.SILVER);
        presentation.setStrokeWidth(2);
        presentation.setFill(Color.GOLD);
        IntroPane.setAlignment(presentation, Pos.TOP_LEFT);

        Text x = new Text("X");
        x.setFont(font3);
        x.setStroke(Color.SILVER);
        x.setStrokeWidth(3);
        x.setFill(Color.GOLD);

        Text gameTitle = new Text("\n\n\ntended\n  Survival\n\n");
        gameTitle.setFont(font);
        gameTitle.setFill(Color.GOLD);
        gameTitle.setStroke(Color.SILVER);
        gameTitle.setStrokeWidth(2);

        Text message = new Text("-Press ANY key to continue-");
        message.setFont(font2);
        message.setFill(Color.GOLD);
        message.setStroke(Color.SILVER);
        message.setStrokeWidth(1);

        // Set Focus
        gameTitle.setFocusTraversable(true);
        message.setFocusTraversable(true);

        // Set Background of Pane
        Background bg = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
        this.setBackground(bg);

        // Animations

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), presentation);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);


        FadeTransition xFadeTransition = new FadeTransition(Duration.millis(5000), x);
        xFadeTransition.setFromValue(0);
        xFadeTransition.setToValue(1);

        FillTransition xFillTransition = new FillTransition(Duration.millis(5000), x, Color.GOLD, Color.RED);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), x);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), x);
        transition.setFromX(-250);
        transition.setFromY(-250);
        transition.setToX(60);
        transition.setToY(7);

        FadeTransition gFadeTransition = new FadeTransition(Duration.millis(6000), gameTitle);
        gFadeTransition.setFromValue(0);
        gFadeTransition.setToValue(1);


        FadeTransition fadeMessage = new FadeTransition(Duration.millis(450), message);
        fadeMessage.setFromValue(0);
        fadeMessage.setToValue(1);
        fadeMessage.setAutoReverse(true);
        fadeMessage.setCycleCount(Animation.INDEFINITE);
        fadeMessage.setDelay(Duration.millis(5000));

        ParallelTransition pnParallel = new ParallelTransition(fadeTransition);

        SequentialTransition sequentialTransition = new SequentialTransition(pnParallel, fadeMessage);
        sequentialTransition.play();

        ParallelTransition parallelTransition = new ParallelTransition(xFadeTransition, xFillTransition, gFadeTransition, rotateTransition, transition);
        parallelTransition.setDelay(Duration.millis(2000));
        parallelTransition.play();

        xFillTransition.setOnFinished(e->{
            gameTitle.setFill(Color.ORANGERED);
            x.setFill(Color.GOLD);
        });
        parallelTransition.setOnFinished(e->{
            setBackground(new Background(backgroundImage));
            this.setOnKeyPressed(ev -> {
                MANAGER.playSound("beginSound");
                mainStage.setScene(new MenuScene());
            });
            this.setOnMouseClicked(ev -> {
                MANAGER.playSound("beginSound");
                mainStage.setScene(new MenuScene());
            });
        });

        gameTitleBox.getChildren().addAll(x, gameTitle);
        gameTitleBox.setAlignment(Pos.CENTER);

        positioning.getChildren().addAll(gameTitleBox, message);
        positioning.setAlignment(Pos.CENTER);

        // Add Children
        this.setCenter(positioning);
        this.setTop(presentation);

    }


}
