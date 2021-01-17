package com.ironhack.rpg_simulator.interfaces;

public interface Attacker {

    //Metódo que sirve para que un Character (Warrior o Wizard) ataque. Se definira en sus respectivas clases
    int[] attack();
    void damage(int damage);
}

