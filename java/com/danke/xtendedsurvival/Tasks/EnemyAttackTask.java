package com.danke.xtendedsurvival.Tasks;

import com.danke.xtendedsurvival.models.Enemies;
import com.danke.xtendedsurvival.panes.EnemyPane;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import static com.danke.xtendedsurvival.Constants.*;

public class EnemyAttackTask implements Runnable {
    Enemies enemy;
    @Override
    public void run() {
        if (!FRONT_VIEW_PANE.getActiveEnemies().isEmpty()){
            for (EnemyPane ep : FRONT_VIEW_PANE.getActiveEnemies()){
                this.enemy = ep.getEnemy();
                System.out.println(player.getHealth());
                enemy.attack();
                MAIN_PANE.updateHpBar();
                System.out.println(player.getHealth());
                Platform.runLater(()->{
                    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(3000), ep);
                    scaleTransition.setByY(2);
                    scaleTransition.play();
                });
            }
        }
    }
}
