package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;

import static com.danke.xtendedsurvival.Constants.player;

public class HealthBar extends Pane {

    Image health = new Image("health.png");
    Enemies enemy;
    Text hp;
    public HealthBar(Enemies e){
        this.enemy = e;
        ImageView healthView = new ImageView(health);
        String currentHp = Integer.toString(e.getHealth());
        String maxHp = Integer.toString(e.getMaxHealth());
        hp = new Text(currentHp + " / " + maxHp);
        InputStream inputStream3 = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStream3, 20);
        hp.setFont(font);
        this.getChildren().addAll(healthView,hp);
        healthView.setX(0);
        healthView.setY(0);
        hp.setX(50);
        hp.setY(35);
    }
    public void updateHealthbar(){
        String currentHp = Integer.toString(enemy.getHealth());
        String maxHp = Integer.toString(enemy.getMaxHealth());
        hp.setText(currentHp + " / " + maxHp);
    }
}
