package com.danke.xtendedsurvival;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class AudioManager {

    HashMap<String, Media> music = new HashMap<>() {{
        put("introMusic", new Media(new File("audio/8bit_race_Furiten.mp3").toURI().toString()));
        put("gameMusic", new Media(new File("audio/NTD4_-_Skip_(4).mp3").toURI().toString()));
    }};
    HashMap<String, Media> effects = new HashMap<>() {{
        put("walk", new Media(new File("audio/step.mp3").toURI().toString()));
        put("startGame", new Media(new File("audio/Level_Up_01_220BPM_-_Soulperium.mp3").toURI().toString()));
        put("buttonHover", new Media(new File("audio/220180__gameaudio__click-pop.wav").toURI().toString()));
        put("gameOver", new Media(new File("audio/538151__fupicat__8bit-fall.wav").toURI().toString()));
        put("select", new Media(new File("audio/505324__daleonfire__8bit-jump.wav").toURI().toString()));
        put("ping", new Media(new File("audio/341695__projectsu012__coins-1.wav").toURI().toString()));
        put("beginSound", new Media(new File("audio/443907__tissman__menu-click.wav").toURI().toString()));
        put("checkpoint", new Media(new File("audio/448266__henryrichard__sfx-clear.wav").toURI().toString()));
        put("warning", new Media(new File("audio/507906__m_cel__warning-sound.mp3").toURI().toString()));
    }};
    MediaPlayer musicPlayer = new MediaPlayer(music.get("introMusic"));
    MediaPlayer soundPlayer = new MediaPlayer(effects.get("startGame"));
    MediaPlayer warnSoundPlayer;

    public AudioManager() {
        musicPlayer.setOnReady(() -> {
            musicPlayer.play();
        });
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sound_settings.txt"));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), ",");
            musicPlayer.setVolume(Double.parseDouble(tokenizer.nextToken()));
            soundPlayer.setVolume(Double.parseDouble(tokenizer.nextToken()));
            musicPlayer.setMute(Boolean.parseBoolean(tokenizer.nextToken()));
            soundPlayer.setMute(Boolean.parseBoolean(tokenizer.nextToken()));
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playMusic(String song){
        double vol = musicPlayer.getVolume();
        boolean muted = musicPlayer.isMute();
        Media audio = music.get(song);
        musicPlayer.stop();
        musicPlayer = new MediaPlayer(audio);
        musicPlayer.setOnReady(() -> {
            musicPlayer.play();
        });
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        musicPlayer.setVolume(vol);
        musicPlayer.setMute(muted);
        musicPlayer.setAutoPlay(true);
    }

    public void playWarning(){
        if (warnSoundPlayer != null && warnSoundPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            return;
        }
        double vol = soundPlayer.getVolume();
        boolean muted = soundPlayer.isMute();
        warnSoundPlayer = new MediaPlayer(effects.get("warning"));
        warnSoundPlayer.seek(Duration.ZERO);
        warnSoundPlayer.setVolume(vol);
        warnSoundPlayer.setMute(muted);
        warnSoundPlayer.setOnReady(() -> {
            warnSoundPlayer.play();
        });
        warnSoundPlayer.setOnEndOfMedia(() -> warnSoundPlayer.dispose());
    }

    public void playSound(String sound){
            double vol = soundPlayer.getVolume();
            boolean muted = soundPlayer.isMute();
            Media audio = effects.get(sound);
            MediaPlayer soundPlayer = new MediaPlayer(audio);
            soundPlayer.setVolume(vol);
            soundPlayer.setMute(muted);
            soundPlayer.setOnReady(() -> {
                soundPlayer.play();
            });
            soundPlayer.setAutoPlay(true);
            soundPlayer.setOnEndOfMedia(() -> soundPlayer.dispose());
    }

    public void stopMusic(){
        musicPlayer.stop();
    }

    public void stopMusic(String song) {
        if (Objects.equals(musicPlayer.getMedia(), music.get(song))) {
            musicPlayer.stop();
        }
    }

    public boolean alreadyPlaying(String song){
        if (Objects.equals(musicPlayer.getMedia(), music.get(song))){
            return true;
        }
        return false;
    }

    public double getMusicVolume(){
        return musicPlayer.getVolume();
    }

    public void muteMusic(){
        musicPlayer.setMute(true);
    }

    public void unmuteMusic(){
        musicPlayer.setMute(false);
    }

    public void setMusicVolume(double vol){
        musicPlayer.setVolume(vol);
    }

    public void stopSound(){
        soundPlayer.stop();
    }

    public boolean isMusicMuted(){
        return musicPlayer.isMute();
    }

    public boolean isSoundMuted(){
        return soundPlayer.isMute();
    }
    public double getSoundVolume(){
        return soundPlayer.getVolume();
    }

    public void muteSound(){
        soundPlayer.setMute(true);
    }

    public void unmuteSound(){
        soundPlayer.setMute(false);
    }

    public void setSoundVolume(double vol){
        soundPlayer.setVolume(vol);
    }

    public void saveSettings()  {
        try {
            FileWriter fw = new FileWriter("sound_settings.txt");
            String mVol, fxVol, mMuted, fxMuted;
            mVol = Double.toString(musicPlayer.getVolume());
            fxVol = Double.toString(soundPlayer.getVolume());
            mMuted = Boolean.toString(musicPlayer.isMute());
            fxMuted = Boolean.toString(soundPlayer.isMute());
            fw.write(mVol + "," + fxVol + "," + mMuted + "," + fxMuted);
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
