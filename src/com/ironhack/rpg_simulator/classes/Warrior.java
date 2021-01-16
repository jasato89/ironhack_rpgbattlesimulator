package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

public class Warrior extends Character implements Atacker {

    //Propieties
    private int stamina;
    private int strength;

    //Constructor
    public Warrior(String name, int hp, boolean isAlive, int stamina, int strength) {
        super(name, hp, isAlive);
        this.stamina = stamina;
        this.strength = strength;
    }

    //Warrior's attack method
    public int[] attack() {

        //We insert the damage into an int
        int[] damage = new int[2];

        //This is a heavy attack
        if( this.stamina >= 5 ) {
            damage[0] = this.strength;
            this.stamina -= 5;
            damage[1] = 1;
        }
        //This is a Weak attack
        else {
            damage[0] = (int)(this.strength/2);
            this.stamina += 1;
            damage[1] = 0;
        }

        System.out.println(this.stamina);
        System.out.println(damage);
        return damage;
    }

    //getters and setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}



