package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {

    private List<Character> aliveMembers;

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
        aliveMembers = partyMembers;
    }

    public Party(int partySize) {
        this.name = RandomDatabaseGenerator.getRandomName();
        this.partySize = partySize;
        partyMembers = generateRandomParty(partySize);
        aliveMembers = partyMembers;
    }


    public int getPartyMaxSize() {
        return partySize;
    }

    public List<Character> updateAlive(){
        List<Character> temp = new ArrayList<>();
        for (Character character : aliveMembers)
        {
            if (character.isAlive())
                temp.add(character);
        }
        aliveMembers = temp;
        return temp;
    }

    public void printAllMembers() {
        int i = 1;
        for (Character character : aliveMembers) {
            if (character.isAlive()) {
                System.out.println(i + " - " + character.toString());
                i++;
            }
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
                Character warrior = RandomDatabaseGenerator.getRandomWarrior();
                if (!partyMembers.isEmpty()) {
                    for (Character name : partyMembers) {
                        if (warrior.getName().equals(name.getName())) {
                            warrior.setName(warrior.getName() + " Jr.");
                        }
                    }
                }
                partyMembers.add(warrior);
            } else {
                Character wizard = RandomDatabaseGenerator.getRandomWizard();
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
