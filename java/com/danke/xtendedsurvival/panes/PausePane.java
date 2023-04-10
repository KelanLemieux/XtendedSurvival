package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.scenes.MenuScene;
import com.danke.xtendedsurvival.scenes.OutroScene;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.*;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.*;

public class PausePane extends Pane {

    Text paused = new Text("Game Paused");
    public PausePane() {
        this.setMinHeight(300);
        this.setMinWidth(300);
        this.setBackground(new Background(new BackgroundFill(Color.web("#373737"), null, null)));
        this.setLayoutX(-1000);
        this.setLayoutY(-1000);

        // Paused Text
        paused.setX(11);
        paused.setY(45);
        this.getChildren().add(paused);
        InputStream inputStream3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font3 = Font.loadFont(inputStream3, 30);
        paused.setFont(font3);
        paused.setFill(Color.RED);
        paused.setStroke(Color.YELLOW);
        FadeTransition ft = new FadeTransition(Duration.millis(500), paused);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();



        // Sound FX Logic
        InputStream inputStream2 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStream2, 20);
        Text soundFx = new Text("SoundFX");
        soundFx.setFont(font);
        soundFx.setFill(Color.web("#FFB800"));
        this.getChildren().add(soundFx);
        soundFx.setX(35);
        soundFx.setY(80);
        Slider fxSlider = new Slider(0, 100, (MANAGER.getSoundVolume()*100));
        this.getChildren().add(fxSlider);
        fxSlider.setLayoutX(185);
        fxSlider.setLayoutY(105);
        soundFx.setStroke(Color.BLACK);
        Image soundOn = new Image(getClass().getResourceAsStream("/OnButton.png"));
        Image soundOff = new Image(getClass().getResourceAsStream("/MutedButton.png"));
        ImageView soundFxButton = new ImageView(soundOn);
        if (MANAGER.isSoundMuted()) {
            soundFxButton.setImage(soundOff);
            fxSlider.setVisible(false);
        } else {
            soundFxButton.setImage(soundOn);
        }
        soundFxButton.setOnMouseClicked(e->{
            if (soundFxButton.getImage() == soundOff){
                soundFxButton.setImage(soundOn);
                fxSlider.setVisible(true);
                MANAGER.unmuteSound();
            } else {
                soundFxButton.setImage(soundOff);
                fxSlider.setVisible(false);
                MANAGER.muteSound();
            }
        });
        fxSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                MANAGER.setSoundVolume(fxSlider.getValue()/100);
            }
        });
        this.getChildren().add(soundFxButton);
        soundFxButton.setX(25);
        soundFxButton.setY(90);

        // Music Logic
        InputStream inputStream = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font2 = Font.loadFont(inputStream, 20);
        Text music = new Text("Music");
        music.setFont(font2);
        music.setFill(Color.web("#FFB800"));
        music.setStroke(Color.BLACK);
        this.getChildren().add(music);
        music.setX(35);
        music.setY(160);
        Slider musicSlider = new Slider(0, 100, (MANAGER.getMusicVolume()*100));
        this.getChildren().add(musicSlider);
        musicSlider.setLayoutX(185);
        musicSlider.setLayoutY(180);
        ImageView musicButton = new ImageView(soundOn);
        if (MANAGER.isMusicMuted()) {
            musicButton.setImage(soundOff);
            musicSlider.setVisible(false);
        } else {
            musicButton.setImage(soundOn);
        }
        musicButton.setOnMouseClicked(e->{
            if (musicButton.getImage() == soundOff){
                musicButton.setImage(soundOn);
                musicSlider.setVisible(true);
                MANAGER.unmuteMusic();
            } else {
                musicButton.setImage(soundOff);
                musicSlider.setVisible(false);
                MANAGER.muteMusic();
            }
        });
        musicSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                MANAGER.setMusicVolume(musicSlider.getValue()/100);
            }
        });
        this.getChildren().add(musicButton);
        musicButton.setX(25);
        musicButton.setY(170);

        // Menu Button
        Image menu = new Image(getClass().getResourceAsStream("/MenuButton.png"));
        ImageView menuButton = new ImageView(menu);
        menuButton.setX(-8);
        menuButton.setY(250);
        menuButton.setOnMouseClicked(e->{
            mainStage.setScene(new MenuScene());
            MANAGER.stopMusic("gameMusic");
            player.saveScore();
        });
        this.getChildren().add(menuButton);

        // Quit Button
        Image quit = new Image(getClass().getResourceAsStream("/QuitButton.png"));
        ImageView quitButton = new ImageView(quit);
        quitButton.setX(180);
        quitButton.setY(250);
        quitButton.setOnMouseClicked(e2->{
            mainStage.close();
            MANAGER.stopMusic();
            MANAGER.saveSettings();
            player.saveScore();
        });
        this.getChildren().add(quitButton);
    }
    public void pauseOn(){
        this.setLayoutX(335);
        this.setLayoutY(230);
    }
    public void pauseOff(){
        this.setLayoutX(-1000);
        this.setLayoutY(-1000);
    }

    public void settings(){
        paused.setText("Settings");
        paused.setX(45);
    }
}
