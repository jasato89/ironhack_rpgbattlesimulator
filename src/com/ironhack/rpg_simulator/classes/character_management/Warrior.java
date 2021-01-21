package com.ironhack.rpg_simulator.classes.character_management;

public class Warrior extends Character {

    //Properties
    private int stamina;
    private int strength;

    //Constructor
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
        setClassName("Warrior");
    }

    //Implement attack into warrior. we can get between a heavy attack and a weak attack
    public int[] attack() {
        //We insert the damage into an int[]
        int[] damage = new int[2];
        //This is a Heavy attack
        if( getStamina()>= 5 ) {
            damage[0] = getStrength();
            setStamina(getStamina() - 5);
            damage[1] = 1;
        }
        //This is a Weak attack
        else {
            damage[0] = getStrength()/2;
            setStamina(getStamina() + 1);
            damage[1] = 2;
        }
        return damage;
    }

    //Getters and setters
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


    public String toString(){
        return "Name: " +getName()  + " Type: Warrior HP: " +
                getHp() + " Stamina: " + getStamina() +" Strength: " + getStrength() + "\n";
    }


}



