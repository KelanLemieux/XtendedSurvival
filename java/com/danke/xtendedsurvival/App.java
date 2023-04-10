package com.danke.xtendedsurvival;

import com.danke.xtendedsurvival.models.Item;
import com.danke.xtendedsurvival.scenes.IntroScene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static com.danke.xtendedsurvival.Constants.MANAGER;
import static com.danke.xtendedsurvival.Constants.player;

public class App extends javafx.application.Application {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("Xtended Survival");
        mainStage.setScene(new IntroScene());
        mainStage.show();
        mainStage.setResizable(false);
        mainStage.setOnCloseRequest(e->{
            MANAGER.saveSettings();
            player.saveScore();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}