package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

import javax.accessibility.AccessibleTable;

public class Wizard extends Character {

    //propiedades
    private int mana;
    private int intelligence;

    //Constructor
    public Wizard(String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(name, hp, isAlive);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    //Método attack de mago
    public int[] attack () {
        //We insert the damage into an int
        int[] damage = new int[2];

        //This is a Fireball
        if( this.mana >= 5 ) {
            damage[0] = this.intelligence;
            this.mana -= 5;
            damage[1] = 1;
        }
        //This is a "Staff hit"
        else {
            damage[0] = 2;
            this.mana += 1;
            damage[1] = 2;
        }

        return damage;
    }
    //implementamos damage
    public void damage(int damage) {
        int hp = getHp();
        hp -= damage;
        if(getHp() <= 0) {
            boolean isAlive = isAlive();
            isAlive = false;
        }
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


