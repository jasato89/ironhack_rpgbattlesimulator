package com.ironhack.rpg_simulator.main;

import com.ironhack.rpg_simulator.classes.Party;

import java.util.ArrayList;
import java.util.List;

public class RandomTeamGeneration {
    public RandomTeamGeneration() {
    }

    public List<Party> generateTwoRandomTeam() {
        List<Party> r = new ArrayList<>();
        r.add(new Party(5));
        r.add(new Party(5));
        return r;
    }
}
