package com.ironhack.rpg_simulator.classes;


public class Warrior extends Character {

    //properties
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
        //This is a heavy attack
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

    //we use this method to show a warrior in console
    public String toString(){
        return "" + getName()  + ", Warrior HP: " +
                getHp() + " STA: " + getStamina() +" STR: " + getStrength();
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



