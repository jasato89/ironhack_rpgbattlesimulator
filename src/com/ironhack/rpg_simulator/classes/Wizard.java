package com.ironhack.rpg_simulator.classes;

public class Wizard extends Character{

    //propiedades
    private int mana;
    private int intelligence;

    //Constructor
    public Wizard(String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(name, hp, isAlive);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    //getters and setters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

/*
Wizard:

mana - number to represent a resource the wizard consumes to cast spells
intelligence - number to calculate how strong the wizard spells are
*/

