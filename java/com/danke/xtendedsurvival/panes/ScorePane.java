package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.scenes.MenuScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.MANAGER;
import static com.danke.xtendedsurvival.Constants.player;

public class ScorePane extends Pane {

    ObservableList<String> scores = FXCollections.observableArrayList();
    public ScorePane(){

        // Background
        Image background = new Image(getClass().getResourceAsStream("/sprite_northWindShrineBG.png"));
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));
        Rectangle rectangle = new Rectangle(362,250,300,300);
        rectangle.setFill(Color.web("#373737"));
        this.getChildren().add(rectangle);

        // Read in scores
        try {
            BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
            String line = reader.readLine();
            if (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                while (tokenizer.hasMoreElements()) {
                    scores.add(tokenizer.nextToken());
                }
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        // ListView of scores
        ListView<String> highScoresView;
        highScoresView = new ListView<>(scores);
        highScoresView.setLayoutX(390);
        highScoresView.setLayoutY(300);
        highScoresView.setMaxHeight(185);
        highScoresView.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        // Used to format each cell that has content
        highScoresView.setCellFactory(e -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
                } else {
                    this.setText(item);
                    InputStream inputStream = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
                    Font font = Font.loadFont(inputStream, 30);
                    this.setTextFill(Color.RED);
                    this.setAlignment(Pos.CENTER);
                    this.setTextAlignment(TextAlignment.CENTER);
                    this.setFont(font);
                }
            }
        });

        this.getChildren().add(highScoresView);

        // Menu Button
        Image menu = new Image(getClass().getResourceAsStream("/MenuButton.png"));
        ImageView menuButton = new ImageView(menu);
        menuButton.setX(415);
        menuButton.setY(500);
        menuButton.setOnMouseClicked(e->{
            mainStage.setScene(new MenuScene());
        });

        // High Scores Text
        Text text = new Text("High Scores");
        InputStream inputStream = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStream, 26);
        text.setFont(font);
        text.setFill(Color.web("#FFB800"));
        text.setX(372);
        text.setY(290);

        this.getChildren().add(text);
        this.getChildren().add(menuButton);
    }
}
