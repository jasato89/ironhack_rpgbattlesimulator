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

/*Both wizards and warrios will have the same attack command defined by an interface called Atacker.

Warriors are strong well armored characters that focus on the attribute strength. Every round a warrior will try to do
a "Heavy attack". The damage of a heavy attack is equals to their strength and every hit will decrease their stamina by
5 points. If he can't make a heavy attack he will do a "Weak attack". The damage of a weak attack is the half of the
strength (truncate decimals). Every weak attack will recover his stamina by 1.

Wizards are the masters of the arcane their main attribute is intelligence. Every round a wizard will try to cast
a "Fireball". The damage of a fireball is equals to his intelligence and every fireball will decrease their mana by 5 points.
If he can't cast a fireball he will do a "Staff hit". The damage of a staff hit is equals to 2. Every staff hit will
recover his mana by 1.*/

