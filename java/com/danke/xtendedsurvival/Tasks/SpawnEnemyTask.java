package com.danke.xtendedsurvival.Tasks;

import com.danke.xtendedsurvival.Monsters.Goblin;
import com.danke.xtendedsurvival.Monsters.Orc;
import com.danke.xtendedsurvival.Monsters.Slime;

import com.danke.xtendedsurvival.models.Enemies;
import com.danke.xtendedsurvival.panes.EnemyPane;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

import static com.danke.xtendedsurvival.Constants.*;

public class SpawnEnemyTask implements Runnable {

    EnemyPane enemyPane;

    @Override
    public void run() {
        ArrayList<Enemies> enemyList = new ArrayList<>();
        enemyList.add(new Slime());
        enemyList.add(new Orc());
        enemyList.add(new Goblin());
        Random random = new Random();
        int enemy = random.nextInt(enemyList.size());
        int spawnArea = random.nextInt(4);
        this.enemyPane = new EnemyPane(enemyList.get(enemy));
        // Check if position is valid
        double x = random.nextDouble(SCREEN_WIDTH - 150);
        double y = random.nextDouble(SCREEN_HEIGHT - 450);
        enemyPane.setLayoutX(x);
        enemyPane.setLayoutY(y);

        Platform.runLater(() -> {
            if (spawnArea == 0) {
                FRONT_VIEW_PANE.getChildren().add(enemyPane);
                FRONT_VIEW_PANE.addToActiveEnemies(enemyPane);
                System.out.println("spawned front");
            } else if (spawnArea == 1) {
                LEFT_VIEW_PANE.getChildren().add(enemyPane);
                LEFT_VIEW_PANE.addToActiveEnemies(enemyPane);

                System.out.println("spawned left");
            } else if (spawnArea == 2) {
                RIGHT_VIEW_PANE.getChildren().add(enemyPane);
                RIGHT_VIEW_PANE.addToActiveEnemies(enemyPane);
                System.out.println("spawned right");
            } else if (spawnArea == 3) {
                BACK_VIEW_PANE.getChildren().add(enemyPane);
                BACK_VIEW_PANE.addToActiveEnemies(enemyPane);
                System.out.println("spawned back");
            }
        });
        Thread t = new Thread(new WarnPlayerTask());
        t.start();

    }
}
