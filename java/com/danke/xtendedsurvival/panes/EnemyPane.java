package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyPane extends Pane {
    HealthBar healthBar;
    Enemies enemy;
    public EnemyPane(Enemies e) {
        this.enemy = e;
        this.healthBar = new HealthBar(enemy);
        ImageView enemyImg = new ImageView(e.getImage());
        this.getChildren().addAll(enemyImg,healthBar);
        enemyImg.setX(0);
        enemyImg.setY(healthBar.getHeight());
        // Set Size
        this.setWidth(enemyImg.getFitWidth());
        this.setHeight(enemyImg.getFitHeight()+healthBar.getHeight());

        healthBar.setLayoutX(this.getLayoutBounds().getWidth()/2-healthBar.getWidth()/2);
        healthBar.setLayoutY(0+enemyImg.getLayoutBounds().getHeight());
    }

    public Enemies getEnemy(){
        return this.enemy;
    }

    public void updateHp(){
        this.healthBar.updateHealthbar();
    }

}
