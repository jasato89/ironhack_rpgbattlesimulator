package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.fight.classes.AttackStats;
import com.ironhack.rpg_simulator.interfaces.Attacker;

public class Wizard extends Character {

    //properties
    private int mana;
    private int intelligence;

    //Constructor
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
        setClassName("Wizard");
    }

    //We implement attack on Wizard, we can get between a Fireball or a Staff hit
    public int[] attack () {
        //We insert the damage into an int[]
        int[] damage = new int[2];

        //This is a Fireball
        if( getMana() >= 5 ) {
            damage[0] = getIntelligence();
            setMana(getMana() + 1);
            damage[1] = 1;
        }
        //This is a "Staff hit"
        else {
            damage[0] = 2;
            setMana(getMana() + 1);
            damage[1] = 2;
        }

        return damage;
    }

    //we use this method to show a wizard in console
    public String toString(){
        return "Name: " +getName()  + "\n Type: Warrior\nHP: " +
                getHp() + "\nIntelligence: " + getIntelligence() +"\nMana: " + getMana() + "\n";
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


