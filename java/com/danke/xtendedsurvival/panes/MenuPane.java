package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.scenes.CharacterSelectionScene;
import com.danke.xtendedsurvival.scenes.OutroScene;
import com.danke.xtendedsurvival.scenes.ScoreScene;
import com.danke.xtendedsurvival.scenes.SettingsScene;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.InputStream;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.*;
import static com.danke.xtendedsurvival.Constants.MANAGER;

public class MenuPane extends Pane {

    public MenuPane() {


        // Audio
        if (!MANAGER.alreadyPlaying("introMusic")){
            MANAGER.playMusic("introMusic");
        }

        // Background
        Image background = new Image(getClass().getResourceAsStream("/sprite_northWindShrineBG.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));


        // Font
        InputStream is = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(is, 60);
        InputStream is2 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font2 = Font.loadFont(is2, 200);

        // XtendedSurvival text
        Text x = new Text("X");
        x.setFont(font2);
        x.setStroke(Color.SILVER);
        x.setStrokeWidth(3);
        x.setFill(Color.GOLD);
        this.getChildren().add(x);
        x.setX(170);
        x.setY(505);
        Text gameTitle = new Text("\n\n\ntended\n  Survival\n\n");
        gameTitle.setFont(font);
        gameTitle.setStroke(Color.SILVER);
        gameTitle.setStrokeWidth(2);
        gameTitle.setFill(Color.ORANGERED);
        this.getChildren().add(gameTitle);
        gameTitle.setY(247);
        gameTitle.setX(315);


        // Animation
        TranslateTransition xUp = new TranslateTransition(Duration.millis(2000), x);
        xUp.setFromY(x.getLayoutY());
        xUp.setToY(x.getLayoutY()-210);
        TranslateTransition gameTitleUp = new TranslateTransition(Duration.millis(2000), gameTitle);
        gameTitleUp.setFromY(gameTitle.getLayoutY());
        gameTitleUp.setToY(gameTitle.getLayoutY()-210);
        ParallelTransition pt = new ParallelTransition(xUp,gameTitleUp);
        pt.play();


        // Menu VBox with image buttons
        VBox menu = new VBox();
        Image play = new Image(getClass().getResourceAsStream("/StartButton.png"));
        Image score = new Image(getClass().getResourceAsStream("/ScoreButton.png"));
        Image settings = new Image(getClass().getResourceAsStream("/SettingsButton.png"));
        Image credits = new Image(getClass().getResourceAsStream("/CreditsButton.png"));
        Image quit = new Image(getClass().getResourceAsStream("/QuitButton2.png"));
        Image playSelected = new Image(getClass().getResourceAsStream("/StartButtonHover.png"));
        Image scoreSelected = new Image(getClass().getResourceAsStream("/ScoreButtonHover.png"));
        Image settingsSelected = new Image(getClass().getResourceAsStream("/SettingsButtonHover.png"));
        Image creditsSelected = new Image(getClass().getResourceAsStream("/CreditsButtonHover.png"));
        Image quitSelected = new Image(getClass().getResourceAsStream("/QuitButtonHover.png"));
        ImageView playButton = new ImageView(play);
        ImageView scoreButton = new ImageView(score);
        ImageView settingsButton = new ImageView(settings);
        ImageView creditsButton = new ImageView(credits);
        ImageView quitButton = new ImageView(quit);
        menu.getChildren().addAll(playButton, scoreButton, settingsButton, creditsButton, quitButton);
        menu.setVisible(false);
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(5);
        menu.setOpaqueInsets(new Insets(0,0,10,0));
        pt.setOnFinished(e->{
            menu.setVisible(true);
        });

        // Button Logic
        // Play Button
        playButton.setOnMouseClicked(e->{
            MANAGER.playSound("ping");
            mainStage.setScene(new CharacterSelectionScene());
        });
        playButton.setOnMouseEntered(e->{
            playButton.setImage(playSelected);
            MANAGER.playSound("buttonHover");
        });
        playButton.setOnMouseExited(e->{
            playButton.setImage(play);
        });

        // Quit Button
        quitButton.setOnMouseClicked(e->{
            mainStage.close();
            MANAGER.stopMusic();
            MANAGER.saveSettings();
            player.saveScore();
        });
        quitButton.setOnMouseEntered(e->{
            quitButton.setImage(quitSelected);
            MANAGER.playSound("buttonHover");
        });
        quitButton.setOnMouseExited(e->{
            quitButton.setImage(quit);
        });

        // Settings Button
        settingsButton.setOnMouseClicked(e->{
            mainStage.setScene(new SettingsScene());
        });
        settingsButton.setOnMouseEntered(e->{
            settingsButton.setImage(settingsSelected);
            MANAGER.playSound("buttonHover");
        });
        settingsButton.setOnMouseExited(e->{
            settingsButton.setImage(settings);
        });

        // Credits
        creditsButton.setOnMouseClicked(e->{
            mainStage.setScene(new OutroScene());
        });
        creditsButton.setOnMouseEntered(e->{
            creditsButton.setImage(creditsSelected);
            MANAGER.playSound("buttonHover");
        });
        creditsButton.setOnMouseExited(e->{
            creditsButton.setImage(credits);
        });

        // Score
        scoreButton.setOnMouseClicked(e->{
            mainStage.setScene(new ScoreScene());
        });
        scoreButton.setOnMouseEntered(e->{
            scoreButton.setImage(scoreSelected);
            MANAGER.playSound("buttonHover");
        });
        scoreButton.setOnMouseExited(e->{
            scoreButton.setImage(score);
        });

        this.getChildren().add(menu);
        menu.setLayoutX(410);
        menu.setLayoutY(380);
    }
}
