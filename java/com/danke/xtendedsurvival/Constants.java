package com.danke.xtendedsurvival;

import com.danke.xtendedsurvival.models.Characters;
import com.danke.xtendedsurvival.models.Enemies;
import com.danke.xtendedsurvival.models.Item;
import com.danke.xtendedsurvival.panes.ControlsPane;
import com.danke.xtendedsurvival.panes.MainPane;
import com.danke.xtendedsurvival.panes.ViewPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;
import java.util.ArrayList;

public class Constants {

    // Screen Settings
    public static final int SCREEN_WIDTH = 1024;
    public static final int SCREEN_HEIGHT = 768;

    public static Characters player = new Characters(new ArrayList<Item>(),100,100,100,10,100);

    public static final AudioManager MANAGER = new AudioManager();
    public static final ViewPane FRONT_VIEW_PANE = new ViewPane("front");
    public static final ViewPane LEFT_VIEW_PANE = new ViewPane("left");
    public static final ViewPane RIGHT_VIEW_PANE = new ViewPane("right");
    public static final ViewPane BACK_VIEW_PANE = new ViewPane("back");
    public static final MainPane MAIN_PANE = new MainPane(new ControlsPane());

}
