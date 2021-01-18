package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.MenuManager;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        //menuManager.loadPartiesFromDatabase(); //error : Cannot invoke "java.io.File.getParentFile()" because "databaseDirParent" is null
        menuManager.mainMenu();
    }
}
