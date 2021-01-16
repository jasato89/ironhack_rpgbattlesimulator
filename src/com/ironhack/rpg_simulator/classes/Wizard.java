package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

import javax.accessibility.AccessibleTable;

public class Wizard extends Character implements Atacker {

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
    public int attack () {
        //Métemos el resultado en la variable damage
        int damage = 0;

        //Esto es un Fireball
        if( this.mana >= 5 ) {
            damage = this.intelligence;
            this.mana -= 5;
        }
        //Esto es un "Staff hit"
        else {
            damage = 2;
            this.mana += 1;
        }

        System.out.println(this.mana);
        System.out.println(damage);
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


