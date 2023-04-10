package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.scenes.IntroScene;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.InputStream;

import static com.danke.xtendedsurvival.App.mainStage;
import static com.danke.xtendedsurvival.Constants.SCREEN_HEIGHT;
import static com.danke.xtendedsurvival.Constants.SCREEN_WIDTH;

public class OutroPane extends Pane {
    public OutroPane(){
        this.setFocusTraversable(true);
        InputStream inputStreamFont = getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf");
        Font font = Font.loadFont(inputStreamFont, 30);
        Text theEnd = new Text("The End");
        Text thanks = new Text("Thanks for Playing");
        Text madeBy = new Text("Made By");
        Text group = new Text("Kelan\nDaniel\nUsama");
        theEnd.setFont(font);
        thanks.setFont(font);
        thanks.setFill(Color.GOLD);
        madeBy.setFill(Color.GOLD);
        madeBy.setFont(font);
        group.setFont(font);
        group.setFill(Color.GOLD);
        theEnd.setFill(Color.GOLD);
        theEnd.setX((SCREEN_WIDTH-theEnd.getLayoutBounds().getWidth())/2);
        theEnd.setY(SCREEN_HEIGHT/2);
        thanks.setX((SCREEN_WIDTH-thanks.getLayoutBounds().getWidth())/2);
        thanks.setY((SCREEN_HEIGHT/2)+40);
        madeBy.setX((SCREEN_WIDTH-madeBy.getLayoutBounds().getWidth())/2);
        madeBy.setY(SCREEN_HEIGHT/2);
        group.setX((SCREEN_WIDTH-group.getLayoutBounds().getWidth())/2);
        group.setY((SCREEN_HEIGHT/2)+40);
        group.setOpacity(0);
        madeBy.setOpacity(0);
        this.getChildren().addAll(theEnd,thanks,madeBy,group);



        // Background
        Background background = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
        this.setBackground(background);

        // Fade Transitions
        FadeTransition fadeTheEnd = new FadeTransition(Duration.millis(2500), theEnd);
        fadeTheEnd.setFromValue(0);
        fadeTheEnd.setToValue(1);
        fadeTheEnd.setAutoReverse(true);
        fadeTheEnd.setCycleCount(2);

        FadeTransition fadeThanks = new FadeTransition(Duration.millis(2500), thanks);
        fadeThanks.setFromValue(0);
        fadeThanks.setToValue(1);
        fadeThanks.setAutoReverse(true);
        fadeThanks.setCycleCount(2);

        FadeTransition fadeMadeBy = new FadeTransition(Duration.millis(2500), madeBy);
        fadeMadeBy.setFromValue(0);
        fadeMadeBy.setToValue(1);
        fadeMadeBy.setAutoReverse(true);
        fadeMadeBy.setCycleCount(2);

        FadeTransition fadeGroup = new FadeTransition(Duration.millis(2500), group);
        fadeGroup.setFromValue(0);
        fadeGroup.setToValue(1);
        fadeGroup.setAutoReverse(true);
        fadeGroup.setCycleCount(2);

        ParallelTransition parallelTheEndThanks = new ParallelTransition(fadeTheEnd,fadeThanks);

        ParallelTransition parallelMadeByGroup = new ParallelTransition(fadeMadeBy,fadeGroup);

        SequentialTransition sequentialTransition = new SequentialTransition(parallelTheEndThanks,parallelMadeByGroup);
        sequentialTransition.play();

        sequentialTransition.setOnFinished(e->{
            mainStage.setScene(new IntroScene());
        });

    }
}
