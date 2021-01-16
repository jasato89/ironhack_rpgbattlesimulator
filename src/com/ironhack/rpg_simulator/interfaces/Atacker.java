package com.ironhack.rpg_simulator.interfaces;

public interface Atacker {

    //Metódo que sirve para que un Character (Warrior o Wizard) ataque. Se definira en sus respectivas clases
    public int attack();
    public void damage(int damage);

}

