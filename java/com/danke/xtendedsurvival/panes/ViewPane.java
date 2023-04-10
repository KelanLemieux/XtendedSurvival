package com.danke.xtendedsurvival.panes;

import com.danke.xtendedsurvival.Monsters.Slime;
import com.danke.xtendedsurvival.models.Enemies;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.HashMap;

import static com.danke.xtendedsurvival.Constants.*;

public class ViewPane extends Pane {

    /**
     * This is where the enemies are spawned
     * This pane sits on-top of the MainPane with the ControlsPane below
     * @param String bgName - sets the background using its name
     */
    HashMap<String, BackgroundImage> backgrounds = new HashMap<>();
    ArrayList<EnemyPane> activeEnemies = new ArrayList<>();

    public ViewPane(String bgName){

        // Set Size
        this.setPrefSize(1024, 530);
        this.setWidth(1024);
        this.setHeight(530);

        // Set Background
        backgrounds.put("front",new BackgroundImage(new Image(getClass().getResourceAsStream("/forest/game_background_1.png")), null, null, BackgroundPosition.CENTER, new BackgroundSize(getWidth(), getHeight(), false, false, false, false)));
        backgrounds.put("left",new BackgroundImage(new Image(getClass().getResourceAsStream("/forest/game_background_2.png")), null, null, BackgroundPosition.CENTER, new BackgroundSize(getWidth(), getHeight(), false, false, false, false)));
        backgrounds.put("right",new BackgroundImage(new Image(getClass().getResourceAsStream("/forest/game_background_3.png")), null, null, BackgroundPosition.CENTER, new BackgroundSize(getWidth(), getHeight(), false, false, false, false)));
        backgrounds.put("back",new BackgroundImage(new Image(getClass().getResourceAsStream("/forest/game_background_4.png")), null, null, BackgroundPosition.CENTER, new BackgroundSize(getWidth(), getHeight(), false, false, false, false)));
        this.setBackground(new Background(backgrounds.get(bgName)));

    }

    /**
     *  Used to set the position of the pane within the parent
     */
    public void setPos(){
        this.setLayoutX(0);
        this.setLayoutY(0);
    }
    public void addToActiveEnemies(EnemyPane ep){
        this.activeEnemies.add(ep);
    }

    public void removeFromActiveEnemies(EnemyPane ep){
        this.activeEnemies.remove(ep);
    }

    public ArrayList<EnemyPane> getActiveEnemies(){
        return this.activeEnemies;
    }

    /**
     * Returns the EnemyPane from the list of active enemies within the view pane
     * @return
     */
    public EnemyPane getSelectedEnemy(){
        for (EnemyPane ep : this.getActiveEnemies()){
            if (ep.getBorder() != null){
                return  ep;
            }
        }
        return null;
    }

}
