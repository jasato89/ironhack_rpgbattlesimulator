package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.MenuManager;

public class Main {
    public static void main(String[] args) {

        MenuManager menuManager = new MenuManager();
        menuManager.loadPartiesFromDatabase();
        menuManager.mainMenu();
    }
}
