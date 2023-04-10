package com.danke.xtendedsurvival.models;

import javafx.scene.image.Image;

import static com.danke.xtendedsurvival.Constants.MAIN_PANE;
import static com.danke.xtendedsurvival.Constants.player;

public class Enemies {
    int health = 100;

    int maxHealth = 100;
    int strength = 1;
    int attackDamage = 10;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    Image image;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth(){return maxHealth;}

    public  void setMaxHealth(int maxHealth){this.maxHealth = maxHealth;}

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Enemies(int health, int maxHealth, int strength, int attackDamage){
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.attackDamage = attackDamage;
    }

    public void attack(){
        player.setHealth(Math.max(player.getHealth()-this.getStrength(),0));
    }

}
