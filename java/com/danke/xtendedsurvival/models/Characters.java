package com.danke.xtendedsurvival.models;

import com.danke.xtendedsurvival.panes.EnemyPane;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static com.danke.xtendedsurvival.Constants.*;

public class Characters {

    ArrayList<Item> inventory = new ArrayList<>();
    int health;
    int maxHealth;
    int strength = 1;
    int attackDamage = 10;
    int score;
    Image skin;
    int mana;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void saveScore(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
            String line = reader.readLine();
            FileWriter fileWriter = new FileWriter("highscores.txt");
            fileWriter.write(line + "," + this.getScore());
            fileWriter.close();
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    int maxMana;

    public void setSkin(Image skin) {
        this.skin = skin;
    }

    public Image getSkin() {
        return skin;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    int speed;

    public Characters(ArrayList<Item> inventory, int health, int speed, int maxHealth, int strength, int mana) {
        this.inventory = inventory;
        this.health = health;
        this.speed = speed;
        this.mana = mana;
        this.maxHealth = maxHealth;
        this.strength = strength;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void attack(EnemyPane enemy) {
        enemy.getEnemy().setHealth(Math.max(enemy.getEnemy().getHealth()-player.getStrength(), 0));
        enemy.updateHp();
        if (enemy.getEnemy().getHealth() == 0 && FRONT_VIEW_PANE.isVisible()){
            enemy.setVisible(false);
            FRONT_VIEW_PANE.removeFromActiveEnemies(enemy);
            FRONT_VIEW_PANE.getChildren().remove(enemy);
        } else if (enemy.getEnemy().getHealth() == 0 && LEFT_VIEW_PANE.isVisible()){
            enemy.setVisible(false);
            LEFT_VIEW_PANE.removeFromActiveEnemies(enemy);
            FRONT_VIEW_PANE.getChildren().remove(enemy);
        } else if (enemy.getEnemy().getHealth() == 0 && RIGHT_VIEW_PANE.isVisible()){
            enemy.setVisible(false);
            RIGHT_VIEW_PANE.removeFromActiveEnemies(enemy);
            FRONT_VIEW_PANE.getChildren().remove(enemy);
        } else if (enemy.getEnemy().getHealth() == 0 && BACK_VIEW_PANE.isVisible()){
            enemy.setVisible(false);
            BACK_VIEW_PANE.removeFromActiveEnemies(enemy);
            FRONT_VIEW_PANE.getChildren().remove(enemy);
        }
        player.setScore(player.getScore()+5);
    }

    public void defend(EnemyPane enemy){
        enemy.getEnemy().getStrength();
    }
}
