package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Party {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private int partySize;
    ArrayList<Character> partyMembers;


    public Party(String name, ArrayList<Character> party) {
        this.name = name;
        this.partyMembers = party;
    }

    public Party(int partySize) {
        this.name = "Team E";
        partyMembers = generateRandomParty(partySize);
        this.partySize = partySize;
    }


    public int getPartyMaxSize() {
        return partySize;
    }

    public void printAllMembers() {
        int i = 1;
        for (Character character : partyMembers) {
            System.out.println(i + " - " + character.toString());
            i++;
        }
    }

    public Character getMemberFromList(int index) {
        return partyMembers.get(index - 1);
    }

    public ArrayList<Character> getPartyMembers() {
        return partyMembers;

    }

    public ArrayList<Character> generateRandomParty(int partySize) {
        partyMembers = new ArrayList<>();

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
