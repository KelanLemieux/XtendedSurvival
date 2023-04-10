package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.Heroes.Knight;
import com.danke.xtendedsurvival.Heroes.Mage;
import com.danke.xtendedsurvival.Heroes.Rogue;
import com.danke.xtendedsurvival.Tasks.TaskRunner;
import com.danke.xtendedsurvival.scenes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.MANAGER;
import static com.danke.xtendedsurvival.Constants.player;

public class CharacterSelectionPane2 extends Pane {

    //TODO Image of weapons that update
    Thread t = null;
    public CharacterSelectionPane2() {

        // Image Background
        Image background = new Image(getClass().getResourceAsStream("/battleback8.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        // Rectangle Background
        Rectangle rect = new Rectangle(824, 568);
        rect.setFill(Color.web("#302727"));
        this.getChildren().add(rect);
        rect.setY(100);
        rect.setX(100);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(5);

        // Image
        Image knight = new Image(getClass().getResourceAsStream("/knight.png"));
        Image rogue = new Image(getClass().getResourceAsStream("/rogue.png"));
        Image mage = new Image(getClass().getResourceAsStream("/knight.png"));
        ImageView character = new ImageView(knight);
        this.getChildren().add(character);
        character.setY(265);
        character.setX(150);
        player.setSkin(knight);

        // Character Name
        Text title = new Text("Knight");
        InputStream inputStream2 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font2 = Font.loadFont(inputStream2, 60);
        title.setFont(font2);
        title.setFill(Color.web("#FFB800"));
        this.getChildren().add(title);
        title.setX(150);
        title.setY(245);

        // Character Text
        InputStream inputStream3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font3 = Font.loadFont(inputStream3, 20);
        String knightDescription = "The Knight is\nequipped with a\nlong-sword and\ncrossbow.";
        String mageDescription = "The Mage attacks\nwith a magical\nstaff and can \ncast spells at\nenemies.";
        String rogueDescription = "The Rogue uses\ndaggers and a\nbow to strike \nenemies up-close,\nand far away.";
        Text description = new Text(knightDescription);
        description.setFont(font3);
        description.setFill(Color.WHITE);
        this.getChildren().add(description);
        description.setX(565);
        description.setY(380);

        // Confirm Button
        Image confirm = new Image(getClass().getResourceAsStream("/Confirm.png"));
        Image confirm2 = new Image(getClass().getResourceAsStream("/ConfirmSelected.png"));
        ImageView confirmButton = new ImageView(confirm);
        this.getChildren().add(confirmButton);
        confirmButton.setX(550);
        confirmButton.setY(550);
        // Hover Events
        confirmButton.setOnMouseEntered(e-> {
            confirmButton.setImage(confirm2);
        });
        confirmButton.setOnMouseExited(e-> {
            confirmButton.setImage(confirm);
        });
        // Click Events
        confirmButton.setOnMouseClicked(e->{
            MANAGER.playSound("startGame");
            mainStage.setScene(new GameScene());
            TaskRunner taskRunner = new TaskRunner();
            mainStage.setOnCloseRequest(ev->{
                taskRunner.close();
            });
            Thread t = new Thread(taskRunner);
            t.start();
        });

        //HBox with Images
        Image knightSelected = new Image(getClass().getResourceAsStream("/KnightSelected.png"));
        Image rogueSelected = new Image(getClass().getResourceAsStream("/RogueSelected.png"));
        Image mageSelected = new Image(getClass().getResourceAsStream("/MageSelected.png"));
        Image knightUnselected = new Image(getClass().getResourceAsStream("/KnightUnselected.png"));
        Image rogueUnselected = new Image(getClass().getResourceAsStream("/RogueUnselected.png"));
        Image mageUnselected = new Image(getClass().getResourceAsStream("/MageUnselected.png"));
        HBox buttons = new HBox();
        buttons.setSpacing(1);
        ImageView knightButton = new ImageView(knightSelected);
        ImageView mageButton = new ImageView(mageUnselected);
        ImageView rogueButton = new ImageView(rogueUnselected);
        buttons.getChildren().addAll(knightButton, mageButton, rogueButton);
        this.getChildren().add(buttons);
        buttons.setLayoutX(103);
        buttons.setLayoutY(103);

        // Knight Button
        knightButton.setOnMouseClicked(e->{
            player = new Knight();
            knightButton.setImage(knightSelected);
            mageButton.setImage(mageUnselected);
            rogueButton.setImage(rogueUnselected);
            title.setFill(Color.web("#FFB800"));
            title.setText("Knight");
            character.setImage(knight);
            description.setText(knightDescription);
        });

        // Rogue Button
        rogueButton.setOnMouseClicked(e->{
            player = new Rogue();
            knightButton.setImage(knightUnselected);
            mageButton.setImage(mageUnselected);
            rogueButton.setImage(rogueSelected);
            title.setFill(Color.web("#CE0000"));
            title.setText("Rogue");
            character.setImage(rogue);
            description.setText(rogueDescription);
        });

        // Mage Button
        mageButton.setOnMouseClicked(e->{
            player = new Mage();
            knightButton.setImage(knightUnselected);
            mageButton.setImage(mageSelected);
            rogueButton.setImage(rogueUnselected);
            title.setFill(Color.web("#7000FF"));
            title.setText("Mage");
            character.setImage(mage);
            description.setText(mageDescription);
        });




    }

}
