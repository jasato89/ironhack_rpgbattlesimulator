package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.Random;

public class Party {


    private int partySize;
    ArrayList<Character> partyMembers;


    public Party(ArrayList<Character> party) {
        this.partyMembers = party;
    }

    public Party(int partySize) {
        partyMembers = generateRandomParty(partySize);
        this.partySize = partySize;
    }


    public int getPartySize() {
        return partySize;
    }

    public void getAllMembers() {
        int i = 1;
        for (Character character : partyMembers) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Object getMemberById(int id) {
        return partyMembers.get(id - 1);
    }

    public ArrayList<Character> getPartyMembers() {
        return partyMembers;

    }

    public ArrayList<Character> generateRandomParty(int partySize) {
        partyMembers = new ArrayList<Character>();
        for (int i = 0; i < partySize; i++) {
            boolean bool = new Random().nextBoolean();
            if (bool) {
                Character warrior = RandomCharacterDatabase.getRandomWarrior();
                if (!partyMembers.isEmpty()) {
                    for (Character name : partyMembers) {
                        if (warrior.getName().equals(name.getName())) {
                            warrior.setName(warrior.getName() + " Jr.");
                        }
                    }
                }
                partyMembers.add(warrior);
            } else {
                Character wizard = RandomCharacterDatabase.getRandomWizard();
                if (!partyMembers.isEmpty()) {
                    for (Character name : partyMembers) {
                        if (wizard.getName().equals(name.getName())) {
                            wizard.setName(wizard.getName() + " Jr.");
                        }
                    }
                }
                partyMembers.add(wizard);
            }
        }

        return partyMembers;
    }


}
