package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.Heroes.Knight;
import com.danke.xtendedsurvival.Monsters.Slime;
import com.danke.xtendedsurvival.Tasks.WarnPlayerTask;
import com.danke.xtendedsurvival.models.Characters;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import static com.danke.xtendedsurvival.Constants.*;
import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;

public class MainPane extends Pane {

    Boolean paused = false;
    VBox checkpointVbox = new VBox();
    Text healthValuesSlime;

    Image backImage;
    Image leftImage;
    Image rightImage;
    Image backWarn;
    Image leftWarn;
    Image rightWarn;
    ImageView backButton;
    ImageView leftButton;
    ImageView rightButton;
    ControlsPane cp;
    public MainPane(ControlsPane cp) {
        this.cp = cp;
        this.getChildren().addAll(FRONT_VIEW_PANE, LEFT_VIEW_PANE, RIGHT_VIEW_PANE, BACK_VIEW_PANE);
        backImage = new Image(getClass().getResourceAsStream("/Back.png"));
        leftImage = new Image(getClass().getResourceAsStream("/Left.png"));
        rightImage = new Image(getClass().getResourceAsStream("/Right.png"));
        backWarn = new Image(getClass().getResourceAsStream("/BackWarn.png"));
        leftWarn = new Image(getClass().getResourceAsStream("/LeftWarn.png"));
        rightWarn = new Image(getClass().getResourceAsStream("/RightWarn.png"));
        backButton = new ImageView(backImage);
        leftButton = new ImageView(leftImage);
        rightButton = new ImageView(rightImage);
        FRONT_VIEW_PANE.setPos();
        LEFT_VIEW_PANE.setPos();
        RIGHT_VIEW_PANE.setPos();
        BACK_VIEW_PANE.setPos();
        FRONT_VIEW_PANE.setVisible(true);
        LEFT_VIEW_PANE.setVisible(false);
        RIGHT_VIEW_PANE.setVisible(false);
        BACK_VIEW_PANE.setVisible(false);


        // Audio
        MANAGER.stopMusic();
        MANAGER.playMusic("gameMusic");

        // Pause Menu
        PausePane pausePane = new PausePane();
        this.getChildren().add(pausePane);

        // Background
//        Random random = new Random();
//        int num = random.nextInt(1,11);
//        Image background = new Image(getClass().getResourceAsStream("/battleback" + num + ".png"));
//        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
//        this.setBackground(new Background(backgroundImage));

//        enemy1 = new Slime();
//        Image slimeEnemy = new Image(getClass().getResourceAsStream("/slime2.png"));
//        ImageView Slime = new ImageView(slimeEnemy);
//        this.getChildren().add(Slime);
//        Slime.setX(700);
//        Slime.setY(250);

        Image shieldImage = new Image(getClass().getResourceAsStream("/shield3.png"));
        ImageView shield = new ImageView(shieldImage);
        shield.setX(50);
        shield.setY(375);
        this.getChildren().add(shield);

        Image swordImage = new Image(getClass().getResourceAsStream("/sword1.png"));
        ImageView sword = new ImageView(swordImage);
        sword.setX(550);
        sword.setY(325);
        this.getChildren().add(sword);

        this.getChildren().add(cp);
        cp.setPos();

        // Controls background
//        Image plate = new Image(getClass().getResourceAsStream("/plate3.png"));
//        ImageView bottomPlate = new ImageView(plate);
//        bottomPlate.setFitHeight(250);
//        bottomPlate.setFitWidth(1024);
//        this.getChildren().add(bottomPlate);
//        bottomPlate.setX(0);
//        bottomPlate.setY(518);

        // Buttons
//        Button left = new Button("Left");
//        Button right = new Button("Right");

        // Health
//        Image health = new Image(getClass().getResourceAsStream("/health2.png"));
//        ImageView healthView = new ImageView(health);
//        this.getChildren().addAll(healthView);
//        healthView.setX(220);
//        healthView.setY(610);
//        String maxHp = Double.toString(player.getMaxHealth());
//        String currentHp = Double.toString(player.getMaxHealth());
//        Text healthValues = new Text(currentHp +" / " + maxHp);
//        this.getChildren().add(healthValues);
//        healthValues.setX(242);
//        healthValues.setY(645);
//        InputStream inputStream3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
//        Font font3 = Font.loadFont(inputStream3, 16);
//        healthValues.setFont(font3);
//        healthValues.setFill(Color.web("#373737"));

//        Image attackImage = new Image(getClass().getResourceAsStream("/attackButton.png"));
//        ImageView attackButton = new ImageView(attackImage);
//        this.getChildren().add(attackButton);
//        attackButton.setX(760);
//        attackButton.setY(550);

//        Image defendImage = new Image(getClass().getResourceAsStream("/defendButton.png"));
//        ImageView defendButton = new ImageView(defendImage);
//        this.getChildren().add(defendButton);
//        defendButton.setX(760);
//        defendButton.setY(620);

//        Image healthSlime = new Image(getClass().getResourceAsStream("/health.png"));
//        ImageView healthViewSlime = new ImageView(healthSlime);
//        this.getChildren().addAll(healthViewSlime);
//        healthViewSlime.setX(720);
//        healthViewSlime.setY(200);
//        String maxHpSlime = Double.toString(enemy1.getMaxHealth());
//        currentEnemy1Health = Double.toString(enemy1.getHealth());
//        Text healthValuesSlime = new Text(currentEnemy1Health +" / " + maxHpSlime);
//        this.getChildren().add(healthValuesSlime);
//        healthValuesSlime.setX(757);
//        healthValuesSlime.setY(235);
//        InputStream inputStream4 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
//        Font font4 = Font.loadFont(inputStream4, 16);
//        healthValuesSlime.setFont(font4);
//        healthValuesSlime.setFill(Color.web("#373737"));

//        attackButton.setOnMouseClicked(e->{
//            System.out.println("Pressed");
//            player.attack();
//            if(player.getStrength() == 10) {
//                try {
//                    Thread.sleep(2500);
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }else if(player.getStrength() == 5){
//                try {
//                    Thread.sleep(700);
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }
//            healthValuesSlime.setText(currentEnemy1Health + " / " + maxHpSlime);
//            if(enemy1.getHealth() == 0) {
//                Slime.setImage(null);
//                healthViewSlime.setImage(null);
//                healthValuesSlime.setText("");
//            }
//
//        });

//        attackButton.setOnMousePressed(e->{
//            Image attackButtonPushed = new Image(getClass().getResourceAsStream("/attackButtonPushed.png"));
//            attackButton.setImage(attackButtonPushed);
//        });
//
//        attackButton.setOnMouseReleased(e->{
//            attackButton.setImage(attackImage);
//        });


        // Checkpoint
        InputStream inputStream = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStream, 75);
        Text checkpoint = new Text("Checkpoint");
        checkpointVbox.getChildren().add(checkpoint);
        checkpoint.setFont(font);
        checkpoint.setFill(Color.RED);
        checkpoint.setStroke(Color.GOLD);
        HBox checkpointButtonHbox = new HBox();
        Image shopUnselected = new Image(getClass().getResourceAsStream("/storeUnselected.png"));
        Image shopSelected = new Image(getClass().getResourceAsStream("/storeSelected.png"));
        Image continueUnselected = new Image(getClass().getResourceAsStream("/continueUnselected.png"));
        Image continueSelected = new Image(getClass().getResourceAsStream("/continueSelected.png"));
        ImageView shopButton = new ImageView(shopUnselected);
        ImageView continueButton = new ImageView(continueUnselected);
        checkpointButtonHbox.getChildren().addAll(shopButton,continueButton);
        checkpointVbox.getChildren().add(checkpointButtonHbox);
        checkpointButtonHbox.setSpacing(15);
        checkpointButtonHbox.setAlignment(Pos.CENTER);
        checkpoint.setTextAlignment(TextAlignment.CENTER);
        checkpointVbox.setLayoutY(200);
        checkpointVbox.setLayoutX(160);
        checkpointVbox.setSpacing(40);
        checkpointVbox.setVisible(false);
        this.getChildren().add(checkpointVbox);
        shopButton.setOnMouseEntered(e->{
            shopButton.setImage(shopSelected);
        });
        shopButton.setOnMouseExited(e->{
            shopButton.setImage(shopUnselected);
        });
        shopButton.setOnMouseClicked(e->{
            //TODO shop pane here
        });
        continueButton.setOnMouseEntered(e->{
            continueButton.setImage(continueSelected);
        });
        continueButton.setOnMouseExited(e->{
            continueButton.setImage(continueUnselected);
        });
        continueButton.setOnMouseClicked(e->{
            checkpointVbox.setVisible(false);
        });

        // Buttons
        this.getChildren().addAll(backButton,leftButton,rightButton);
        backButton.setX((SCREEN_WIDTH/2)-25);
        backButton.setY(SCREEN_HEIGHT-50);
        leftButton.setX(0);
        leftButton.setY(SCREEN_HEIGHT/2);
        rightButton.setX(SCREEN_WIDTH-50);
        rightButton.setY(SCREEN_HEIGHT/2);

        leftButton.setOnMouseClicked(e->{
            WarnPlayerTask wpt = new WarnPlayerTask();
            Thread t = new Thread(wpt);
            t.start();
            cp.resetIndex();
            if (FRONT_VIEW_PANE.isVisible()){
                FRONT_VIEW_PANE.setVisible(false);
                LEFT_VIEW_PANE.setVisible(true);
            } else if (LEFT_VIEW_PANE.isVisible()){
                LEFT_VIEW_PANE.setVisible(false);
                BACK_VIEW_PANE.setVisible(true);
            } else if (RIGHT_VIEW_PANE.isVisible()){
                RIGHT_VIEW_PANE.setVisible(false);
                FRONT_VIEW_PANE.setVisible(true);
            } else if (BACK_VIEW_PANE.isVisible()){
                BACK_VIEW_PANE.setVisible(false);
                RIGHT_VIEW_PANE.setVisible(true);
            }
        });
        rightButton.setOnMouseClicked(e->{
            WarnPlayerTask wpt = new WarnPlayerTask();
            Thread t = new Thread(wpt);
            t.start();
            cp.resetIndex();
            if (FRONT_VIEW_PANE.isVisible()){
                FRONT_VIEW_PANE.setVisible(false);
                RIGHT_VIEW_PANE.setVisible(true);
            } else if (LEFT_VIEW_PANE.isVisible()){
                LEFT_VIEW_PANE.setVisible(false);
                FRONT_VIEW_PANE.setVisible(true);
            } else if (RIGHT_VIEW_PANE.isVisible()){
                RIGHT_VIEW_PANE.setVisible(false);
                BACK_VIEW_PANE.setVisible(true);
            } else if (BACK_VIEW_PANE.isVisible()){
                BACK_VIEW_PANE.setVisible(false);
                LEFT_VIEW_PANE.setVisible(true);
            }
        });
        backButton.setOnMouseClicked(e->{
            WarnPlayerTask wpt = new WarnPlayerTask();
            Thread t = new Thread(wpt);
            t.start();
            cp.resetIndex();
            if (FRONT_VIEW_PANE.isVisible()){
                FRONT_VIEW_PANE.setVisible(false);
                BACK_VIEW_PANE.setVisible(true);
            } else if (LEFT_VIEW_PANE.isVisible()){
                LEFT_VIEW_PANE.setVisible(false);
                RIGHT_VIEW_PANE.setVisible(true);
            } else if (RIGHT_VIEW_PANE.isVisible()){
                RIGHT_VIEW_PANE.setVisible(false);
                LEFT_VIEW_PANE.setVisible(true);
            } else if (BACK_VIEW_PANE.isVisible()){
                BACK_VIEW_PANE.setVisible(false);
                FRONT_VIEW_PANE.setVisible(true);
            }
        });
    }

    public void checkpoint(){
        checkpointVbox.setVisible(true);
        MANAGER.playSound("checkpoint");
    }

// void updateHPEnemy1(){
//        String maxHpSlime = Double.toString(enemy1.getMaxHealth());
//        String currentHpSlime = Double.toString(enemy1.getHealth() - player.getStrength());
//        this.healthValuesSlime = new Text(currentHpSlime + " / " + maxHpSlime);
//    }

    public void backWarn(){
        backButton.setImage(backWarn);
        MANAGER.playWarning();
    }

    public void leftWarn(){
        leftButton.setImage(leftWarn);
        MANAGER.playWarning();
    }

    public void rightWarn(){
        rightButton.setImage(rightWarn);
        MANAGER.playWarning();
    }
    public void backUnwarn(){
        backButton.setImage(backImage);
    }

    public void leftUnwarn(){
        leftButton.setImage(leftImage);
    }

    public void rightUnwarn(){
        rightButton.setImage(rightImage);
    }

    public void updateHpBar(){
        cp.setHealthText(player.getHealth() + " / " + player.getMaxHealth());
    }
}
