package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.Random;

public class Party {
    ArrayList<Character> party = new ArrayList<Character>();
    private final int PARTY_LIMIT = 10;


    public Party(ArrayList<Character> party) {
        this.party = party;
    }

    public void getAllMembers() {
        int i = 0;
        for (Character character : party) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Object getMemberById(int id) {
        return party.get(id);
    }

    public ArrayList<Character> getParty() {
        return party;

    }

    public ArrayList<Character> generateRandomParty() {
        party.clear();
        for (int i = 0; i < PARTY_LIMIT; i++) {
            boolean bool = new Random().nextBoolean();
            if (bool) {
                Character warrior = RandomCharacterDatabase.getRandomWarrior();
                party.add(warrior);
            } else {
                Character wizard = RandomCharacterDatabase.getRandomWizard();
                party.add(wizard);
            }
        }
        return this.party;
    }


}
