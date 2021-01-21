package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.MenuManager;
import com.ironhack.rpg_simulator.output_lib.Output;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        Output.playSound("music/intro.wav");
        Output.printIntro();
        MenuManager menuManager = new MenuManager();
        menuManager.loadPartiesFromDatabase();
        menuManager.mainMenu();
    }
}
