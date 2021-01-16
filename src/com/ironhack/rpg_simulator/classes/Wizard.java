package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

import javax.accessibility.AccessibleTable;

public class Wizard extends Character implements Atacker {

    //propieties
    private int mana;
    private int intelligence;

    //Constructor
    public Wizard(String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(name, hp, isAlive);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    //Wizard's attack method
    public int attack () {
        //We insert the damage into an int
        int damage = 0;

        //This is a Fireball
        if( this.mana >= 5 ) {
            damage = this.intelligence;
            this.mana -= 5;
        }
        //This is a "Staff hit"
        else {
            damage = 2;
            this.mana += 1;
        }

        System.out.println(this.mana);
        System.out.println(damage);
        return damage;
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


