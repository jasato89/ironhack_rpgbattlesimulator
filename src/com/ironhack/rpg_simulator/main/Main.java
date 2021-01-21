package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.MenuManager;
import com.ironhack.rpg_simulator.output_lib.Output;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Output.printIntro();
        MenuManager menuManager = new MenuManager();
        menuManager.loadPartiesFromDatabase();
        menuManager.mainMenu();
    }
}
