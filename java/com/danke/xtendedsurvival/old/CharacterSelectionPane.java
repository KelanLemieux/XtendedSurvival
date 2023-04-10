package com.danke.xtendedsurvival.old;

import com.danke.xtendedsurvival.scenes.GameScene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.InputStream;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.player;

public class CharacterSelectionPane extends GridPane {

    MediaPlayer mediaPlayer = null;
    Media media = new Media(new File("audio/Level_Up_01_220BPM_-_Soulperium.mp3").toURI().toString());


    public CharacterSelectionPane(){

        // Set Background of Pane
        Image background = new Image(getClass().getResourceAsStream("/background_glacial_mountains.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        setBackground(new Background(backgroundImage));

        // Import Font
        InputStream is = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(is, 20);

        // TODO Update Images and Button Handlers for each character
        // Knight
        // Character Image
        ImageView knightImage = new ImageView(new Image("knight4.png"));
        knightImage.setFitHeight(230);
        knightImage.setFitWidth(230);
        this.add(knightImage,0,0);
        // Weapon Image
        ImageView knightWeapons = new ImageView(new Image("knights_weapons2.png"));
        knightWeapons.setFitHeight(230);
        knightWeapons.setFitWidth(230);
        this.add(knightWeapons,1,0);
        // Details
        VBox vb1 = new VBox();
        Button knightButton = new Button("Confirm Knight");
        Text knightDescription = new Text("The knight is a character equipped with a long sword and crossbow.");
        Text knightTitle = new Text("Knight");
        vb1.getChildren().addAll(knightTitle, knightDescription, knightButton);
        this.add(vb1,2,0);
        vb1.setPadding(new Insets(100, 0, 100, 0));

        // Mage
        // Character Image
        ImageView mageImage = new ImageView(new Image("knight4.png"));
        mageImage.setFitHeight(230);
        mageImage.setFitWidth(230);
        this.add(mageImage,0,1);
        // Weapon Image
        ImageView mageWeapons = new ImageView(new Image("knights_weapons2.png"));
        mageWeapons.setFitHeight(230);
        mageWeapons.setFitWidth(230);
        this.add(mageWeapons,1,1);
        // Details
        VBox vb2 = new VBox();
        Button mageButton = new Button("Confirm Mage");
        Text mageDescription = new Text("The Mage is a character equipped with a staff and book.");
        Text mageTitle = new Text("Mage");
        vb2.getChildren().addAll(mageTitle, mageDescription, mageButton);
        this.add(vb2,2,1);
        vb2.setPadding(new Insets(100, 0, 100, 0));

        // Rogue
        // Character Image
        ImageView rogueImage = new ImageView(new Image("rogue.png"));
        rogueImage.setFitHeight(230);
        rogueImage.setFitWidth(230);
        this.add(rogueImage,0,2);
        // Weapon Image
        ImageView rogueWeapons = new ImageView(new Image("knights_weapons2.png"));
        rogueWeapons.setFitHeight(230);
        rogueWeapons.setFitWidth(230);
        this.add(rogueWeapons,1,2);
        // Details
        VBox vb3 = new VBox();
        Button rogueButton = new Button("Confirm Rogue");
        Text rogueDescription = new Text("The rogue is a character equipped with a dagger and bow.");
        Text rogueTitle = new Text("Rogue");
        vb3.getChildren().addAll(rogueTitle, rogueDescription, rogueButton);
        this.add(vb3,2,2);
        vb3.setPadding(new Insets(100, 0, 0, 0));

        // Set titles to custom font
        knightTitle.setFont(font);
        rogueTitle.setFont(font);
        mageTitle.setFont(font);
        knightTitle.setFill(Color.GOLD);
        knightDescription.setFill(Color.WHITE);
        rogueTitle.setFill(Color.GOLD);
        rogueDescription.setFill(Color.WHITE);
        mageTitle.setFill(Color.GOLD);
        mageDescription.setFill(Color.WHITE);

        // Set Spacing between grid elements
        this.setHgap(10);
        this.setVgap(10);

        // Buttons and Handlers
        // Knight Button
        knightButton.setFocusTraversable(true);
        knightButton.setOnAction(e->{
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(50);
            mediaPlayer.play();
            player.setSkin(new Image("top_knight.png"));
            mainStage.setScene(new GameScene());
        });

        // Mage Button
        mageButton.setFocusTraversable(true);
        mageButton.setOnAction(e->{
            player.setSkin(new Image("character.png"));
            mainStage.setScene(new GameScene());
        });

        // Rogue Button
        rogueButton.setFocusTraversable(true);
        rogueButton.setOnAction(e->{
            player.setSkin(new Image("rogue.png"));
            mainStage.setScene(new GameScene());
        });
    }

}
