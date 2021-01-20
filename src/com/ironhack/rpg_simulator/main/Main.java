package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.MenuManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuManager menuManager = new MenuManager();
        menuManager.loadPartiesFromDatabase();
        menuManager.mainMenu();
    }
}
