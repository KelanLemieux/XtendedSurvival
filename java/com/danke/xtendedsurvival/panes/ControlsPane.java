package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.Heroes.Rogue;
import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;

import static com.danke.xtendedsurvival.Constants.*;

public class ControlsPane extends Pane {

    Text healthValues;
    int index = 0;

    public ControlsPane() {
        // Background
        Image plateBackground = new Image(getClass().getResourceAsStream("/plate3.png"));
        ImageView background = new ImageView(plateBackground);
        background.setFitHeight(250);
        background.setFitWidth(1024);
        this.getChildren().add(background);

        // Size
        this.setWidth(1024);
        this.setHeight(250);

        // Character Image
        ImageView characterImage = new ImageView(player.getSkin());
        this.getChildren().add(characterImage);
        characterImage.setX(50);
        characterImage.setY(50);
        characterImage.setFitHeight(150);
        characterImage.setFitWidth(150);

        // Health
        Image health = new Image(getClass().getResourceAsStream("/health2.png"));
        ImageView healthView = new ImageView(health);
        this.getChildren().addAll(healthView);
        healthView.setX(220);
        healthView.setY(95);
        String maxHp = Double.toString(player.getMaxHealth());
        String currentHp = Double.toString(player.getMaxHealth());
        healthValues = new Text(currentHp +" / " + maxHp);
        this.getChildren().add(healthValues);
        healthValues.setX(242);
        healthValues.setY(130);
        InputStream inputStream3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font3 = Font.loadFont(inputStream3, 16);
        healthValues.setFont(font3);
        healthValues.setFill(Color.web("#373737"));

        // Attack Button
        Image attackImage = new Image(getClass().getResourceAsStream("/attackButton.png"));
        ImageView attackButton = new ImageView(attackImage);
        this.getChildren().add(attackButton);
        attackButton.setX(760);
        attackButton.setY(50);

        attackButton.setOnMouseClicked(e-> {
            // If viewpane is active and has enemies
            if(FRONT_VIEW_PANE.isVisible() && !FRONT_VIEW_PANE.getActiveEnemies().isEmpty()){
                // check for which one has the border
                for (EnemyPane ep : FRONT_VIEW_PANE.getActiveEnemies()){
                    if (ep.getBorder() != null){
                        player.attack(FRONT_VIEW_PANE.getActiveEnemies().get(FRONT_VIEW_PANE.getActiveEnemies().indexOf(ep)));
                        break;
                    }
                }
            } else if(BACK_VIEW_PANE.isVisible() && !BACK_VIEW_PANE.getActiveEnemies().isEmpty()){
                for (EnemyPane ep : BACK_VIEW_PANE.getActiveEnemies()){
                    if (ep.getBorder() != null){
                        player.attack(BACK_VIEW_PANE.getActiveEnemies().get(BACK_VIEW_PANE.getActiveEnemies().indexOf(ep)));
                        break;
                    }
                }
            } else if(LEFT_VIEW_PANE.isVisible() && !LEFT_VIEW_PANE.getActiveEnemies().isEmpty()){
                for (EnemyPane ep : LEFT_VIEW_PANE.getActiveEnemies()){
                    if (ep.getBorder() != null){
                        player.attack(LEFT_VIEW_PANE.getActiveEnemies().get(LEFT_VIEW_PANE.getActiveEnemies().indexOf(ep)));
                        break;
                    }
                }
            } else if(RIGHT_VIEW_PANE.isVisible() && !RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()){
                for (EnemyPane ep : RIGHT_VIEW_PANE.getActiveEnemies()){
                    if (ep.getBorder() != null){
                        player.attack(RIGHT_VIEW_PANE.getActiveEnemies().get(RIGHT_VIEW_PANE.getActiveEnemies().indexOf(ep)));
                        break;
                    }
                }
            }
//                    if (player.getStrength() == 10) {
//                        try {
//                            Thread.sleep(2500);
//                        } catch (Exception exception) {
//                            exception.printStackTrace();
//                        }
//                    } else if (player.getStrength() == 5) {
//                        try {
//                            Thread.sleep(700);
//                        } catch (Exception exception) {
//                            exception.printStackTrace();
//                        }
//                    }
                });

        attackButton.setOnMousePressed(e->{
            Image attackButtonPushed = new Image(getClass().getResourceAsStream("/attackButtonPushed.png"));
            attackButton.setImage(attackButtonPushed);
        });

        attackButton.setOnMouseReleased(e->{
            attackButton.setImage(attackImage);
        });

        // Defend Button
        Image defendImage = new Image(getClass().getResourceAsStream("/defendButton.png"));
        ImageView defendButton = new ImageView(defendImage);
        this.getChildren().add(defendButton);
        defendButton.setX(760);
        defendButton.setY(125);

        // Select Enemy Buttons
        Image enemyCycleLeft = new Image(getClass().getResourceAsStream("/CycleLeft.png"));
        Image enemyCycleRight = new Image(getClass().getResourceAsStream("/CycleRight.png"));
        ImageView cycleRightButton = new ImageView(enemyCycleRight);
        ImageView cycleLeftButton = new ImageView(enemyCycleLeft);
        this.getChildren().addAll(cycleRightButton, cycleLeftButton);
        cycleRightButton.setX(925);
        cycleRightButton.setY(100);
        cycleLeftButton.setX(715);
        cycleLeftButton.setY(100);

        cycleLeftButton.setOnMouseClicked(e->{
            // If viewpane is active and has enemies
            if (FRONT_VIEW_PANE.isVisible() && !FRONT_VIEW_PANE.getActiveEnemies().isEmpty()){
                // Go through each enemy
                for (EnemyPane ep : FRONT_VIEW_PANE.getActiveEnemies()) {
                    // Check if its equal to index
                    if (FRONT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // Draw a border
                        FRONT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                    } else {
                        // Otherwise set null border
                        ep.setBorder(null);
                    }
                }
                // set next index to the highest value if index is 0
                if(index == 0){
                   index = FRONT_VIEW_PANE.getActiveEnemies().size()-1;
               } else {
                   // Otherwise minus 1
                    index -= 1;
               }
            } else if (BACK_VIEW_PANE.isVisible() && !BACK_VIEW_PANE.getActiveEnemies().isEmpty()){
                    // Go through each enemy
                    for (EnemyPane ep : BACK_VIEW_PANE.getActiveEnemies()) {
                        // Check if its equal to index
                        if (BACK_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                            // Draw a border
                            BACK_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        } else {
                            // Otherwise set null border
                            ep.setBorder(null);
                        }
                    }
                    // set next index to the highest value if index is 0
                    if(index == 0){
                        index = BACK_VIEW_PANE.getActiveEnemies().size()-1;
                    } else {
                        // Otherwise minus 1
                        index -= 1;
                    }
            } else if (LEFT_VIEW_PANE.isVisible() && !LEFT_VIEW_PANE.getActiveEnemies().isEmpty()){
                    // Go through each enemy
                    for (EnemyPane ep : LEFT_VIEW_PANE.getActiveEnemies()) {
                        // Check if its equal to index
                        if (LEFT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                            // Draw a border
                            LEFT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        } else {
                            // Otherwise set null border
                            ep.setBorder(null);
                        }
                    }
                    // set next index to the highest value if index is 0
                    if(index == 0){
                        index = LEFT_VIEW_PANE.getActiveEnemies().size()-1;
                    } else {
                        // Otherwise minus 1
                        index -= 1;
                    }
            } else if (RIGHT_VIEW_PANE.isVisible() && !RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                // Go through each enemy
                for (EnemyPane ep : RIGHT_VIEW_PANE.getActiveEnemies()) {
                    // Check if its equal to index
                    if (RIGHT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // Draw a border
                        RIGHT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                    } else {
                        // Otherwise set null border
                        ep.setBorder(null);
                    }
                }
                // set next index to the highest value if index is 0
                if (index == 0) {
                    index = RIGHT_VIEW_PANE.getActiveEnemies().size() - 1;
                } else {
                    // Otherwise minus 1
                    index -= 1;
                }
            }
        });

        // Goes through the ArrayList in ascending order and sets a border on 1 of the elements matching the current index
        cycleRightButton.setOnMouseClicked(e->{
            if (FRONT_VIEW_PANE.isVisible() && !FRONT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                // loop through all enemies on the pane
                for (EnemyPane ep : FRONT_VIEW_PANE.getActiveEnemies()){
                    // if the enemy has the same value as index
                    if (FRONT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // draw a border
                        FRONT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        // Otherwise
                    } else {
                        // Set to null
                        ep.setBorder(null);
                    }
                }
                // If index is greater or equal to the size of the array, set index to 0
                if (index >= FRONT_VIEW_PANE.getActiveEnemies().size()-1){
                    index = 0;
                    // Otherwise
                } else {
                    // add 1 to index
                    index += 1;
                }
            } else if (LEFT_VIEW_PANE.isVisible() && !LEFT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                // loop through all enemies on the pane
                for (EnemyPane ep : LEFT_VIEW_PANE.getActiveEnemies()){
                    // if the enemy has the same value as index
                    if (LEFT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // draw a border
                        LEFT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        // Otherwise
                    } else {
                        // Set to null
                        ep.setBorder(null);
                    }
                }
                // If index is greater or equal to the size of the array, set index to 0
                if (index >= LEFT_VIEW_PANE.getActiveEnemies().size()-1){
                    index = 0;
                    // Otherwise
                } else {
                    // add 1 to index
                    index += 1;
                }
            } else if (RIGHT_VIEW_PANE.isVisible() && !RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                // loop through all enemies on the pane
                for (EnemyPane ep : RIGHT_VIEW_PANE.getActiveEnemies()){
                    // if the enemy has the same value as index
                    if (RIGHT_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // draw a border
                        RIGHT_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        // Otherwise
                    } else {
                        // Set to null
                        ep.setBorder(null);
                    }
                }
                // If index is greater or equal to the size of the array, set index to 0
                if (index >= RIGHT_VIEW_PANE.getActiveEnemies().size()-1){
                    index = 0;
                    // Otherwise
                } else {
                    // add 1 to index
                    index += 1;
                }
                // Check if viewpane is active and if it has enemies
            } else if (BACK_VIEW_PANE.isVisible() && !BACK_VIEW_PANE.getActiveEnemies().isEmpty()) {
                // loop through all enemies on the pane
                for (EnemyPane ep : BACK_VIEW_PANE.getActiveEnemies()){
                    // if the enemy has the same value as index
                    if (BACK_VIEW_PANE.getActiveEnemies().indexOf(ep) == index) {
                        // draw a border
                        BACK_VIEW_PANE.getActiveEnemies().get(index).setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
                        // Otherwise
                    } else {
                        // Set to null
                        ep.setBorder(null);
                    }
                }
                // If index is greater or equal to the size of the array, set index to 0
                if (index >= BACK_VIEW_PANE.getActiveEnemies().size()-1){
                    index = 0;
                    // Otherwise
                } else {
                    // add 1 to index
                    index += 1;
                }
            }
        });

    }

    public void resetIndex(){
        this.index = 0;
    }

    public void setPos(){
        this.setLayoutX(0);
        this.setLayoutY(518);
    }

    public void setHealthText(String s){
        this.healthValues.setText(s);
    }

}
