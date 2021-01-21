package com.ironhack.rpg_simulator.classes.fight;

import com.ironhack.rpg_simulator.classes.character_management.Character;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {

    //Properties
    private List<Character> graveyard1;
    private List<Character> graveyard2;

    //Constructor
    public Graveyard() {
        this.graveyard1 = new ArrayList<>();
        this.graveyard2 = new ArrayList<>();
    }

    public void addSoldier(Character soldier, int team) {
        if(team == 1) {
            this.graveyard1.add(soldier);
        } else if (team == 2) {
            this.graveyard2.add(soldier);
        }
    }

    //Getters and setters
    public List<Character> getGraveyard1() {
        return graveyard1;
    }

    public void setGraveyard1(List<Character> graveyard1) {
        this.graveyard1 = graveyard1;
    }

    public List<Character> getGraveyard2() {
        return graveyard2;
    }

    public void setGraveyard2(List<Character> graveyard2) {
        this.graveyard2 = graveyard2;
    }
}
