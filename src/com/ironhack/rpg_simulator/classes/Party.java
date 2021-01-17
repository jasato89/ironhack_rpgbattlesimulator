package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.Random;

public class Party {

    private final int PARTY_LIMIT = 10;
    ArrayList<Character> party;


    public Party(ArrayList<Character> party) {
        this.party = party;
    }

    public Party() {
        party = generateRandomParty();
    }

    public void getAllMembers() {
        int i = 1;
        for (Character character : party) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Object getMemberById(int id) {
        return party.get(id - 1);
    }

    public ArrayList<Character> getParty() {
        return party;

    }

    public ArrayList<Character> generateRandomParty() {
        party = new ArrayList<Character>();
        for (int i = 0; i < PARTY_LIMIT; i++) {
            boolean bool = new Random().nextBoolean();
            if (bool) {
                Character warrior = RandomCharacterDatabase.getRandomWarrior();
                if (!party.isEmpty()) {
                    for (Character name : party) {
                        if (warrior.getName().equals(name.getName())) {
                            warrior.setName(warrior.getName() + " Jr.");
                        }
                    }
                }
                party.add(warrior);
            } else {
                Character wizard = RandomCharacterDatabase.getRandomWizard();
                if (!party.isEmpty()) {
                    for (Character name : party) {
                        if (wizard.getName().equals(name.getName())) {
                            wizard.setName(wizard.getName() + " Jr.");
                        }
                    }
                }
                party.add(wizard);
            }
        }

        return party;
    }


}
