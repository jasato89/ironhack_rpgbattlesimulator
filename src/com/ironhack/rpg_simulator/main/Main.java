package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.menu_management.MenuManager;
import com.ironhack.rpg_simulator.classes.menu_management.Output;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        MenuManager menuManager = new MenuManager();
        menuManager.loadPartiesFromDatabase();
        Output.printIntro();
        Output.playSound("src/com/ironhack/rpg_simulator/assets/music/battleground.wav");
        menuManager.mainMenu();
    }
}
