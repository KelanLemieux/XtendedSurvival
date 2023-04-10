package com.danke.xtendedsurvival.Tasks;

import com.danke.xtendedsurvival.AudioManager;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import static com.danke.xtendedsurvival.Constants.*;

public class WarnPlayerTask implements Runnable {

    @Override
    public void run() {
        // Front Facing warning
        if (FRONT_VIEW_PANE.isVisible()) {
            Platform.runLater(() -> {
                if (!RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.rightWarn();
                } else {
                    MAIN_PANE.rightUnwarn();
                }
                if (!LEFT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.leftWarn();
                } else {
                    MAIN_PANE.leftUnwarn();
                }
                if (!BACK_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.backWarn();
                } else {
                    MAIN_PANE.backUnwarn();
                }
            });
        }
        // Back Facing warning
        if (BACK_VIEW_PANE.isVisible()) {
            Platform.runLater(() -> {
                if (!LEFT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.rightWarn();
                } else {
                    MAIN_PANE.rightUnwarn();
                }
                if (!RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.leftWarn();
                } else {
                    MAIN_PANE.leftUnwarn();
                }
                if (!FRONT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.backWarn();
                } else {
                    MAIN_PANE.backUnwarn();
                }
            });
        }
        // Left Facing warning
        if (LEFT_VIEW_PANE.isVisible()) {
            Platform.runLater(() -> {
                if (!FRONT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.rightWarn();
                } else {
                    MAIN_PANE.rightUnwarn();
                }
                if (!BACK_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.leftWarn();
                } else {
                    MAIN_PANE.leftUnwarn();
                }
                if (!RIGHT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.backWarn();
                } else {
                    MAIN_PANE.backUnwarn();
                }
            });

        }
        // Right Facing warning
        if (RIGHT_VIEW_PANE.isVisible()) {
            Platform.runLater(() -> {
                if (!BACK_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.rightWarn();
                } else {
                    MAIN_PANE.rightUnwarn();
                }
                if (!FRONT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.leftWarn();
                } else {
                    MAIN_PANE.leftUnwarn();
                }
                if (!LEFT_VIEW_PANE.getActiveEnemies().isEmpty()) {
                    MAIN_PANE.backWarn();
                } else {
                    MAIN_PANE.backUnwarn();
                }
            });
       }
    }
}
