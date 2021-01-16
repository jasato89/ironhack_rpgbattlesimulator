package com.ironhack.rpg_simulator.fight.classes;

import com.ironhack.rpg_simulator.classes.Character;
import com.ironhack.rpg_simulator.interfaces.Atacker;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    private List<Atacker> graveyard1;
    private List<Atacker> graveyard2;

    public void addSoldier(int team, Atacker soldier) {
        if(team == 1) {
            this.graveyard1.add(soldier);
        } else if (team == 2) {
            this.graveyard2.add(soldier);
        }
    }

    public Atacker getSoldierByIndex(int team, int index) {
        if(team == 1) {
            return graveyard1.get(index);
        } else if (team == 2) {
            return graveyard2.get(index);
        } else {
            return null;
        }
    }

    public List<List<Atacker>> getAllSoldiers() {
        List<List<Atacker>> deadSoldiers = new ArrayList<>();
        deadSoldiers.add(graveyard1);
        deadSoldiers.add(graveyard2);
        return deadSoldiers;
    }

}
