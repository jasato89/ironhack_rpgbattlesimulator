package com.ironhack.rpg_simulator.classes;

import com.ironhack.rpg_simulator.interfaces.Atacker;

public class Warrior extends Character implements Atacker {

    //propiedades
    private int stamina;
    private int strength;

    //Constructor
    public Warrior(String name, int hp, boolean isAlive, int stamina, int strength) {
        super(name, hp, isAlive);
        this.stamina = stamina;
        this.strength = strength;
    }

    //Implementamos el método attack(), especifico para el guerrero
    public int attack() {

        //Métemos el resultado en la variable damage
        int damage = 0;

        //Esto es un heavy attack
        if( this.stamina >= 5 ) {
            damage = this.strength;
            this.stamina -= 5;
        }
        //Esto es un Weak attack
        else {
            damage = (int)(this.strength/2);
            this.stamina += 1;
        }

        System.out.println(this.stamina);
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



