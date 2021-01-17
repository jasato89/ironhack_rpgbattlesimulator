package com.ironhack.rpg_simulator.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {

    private String name;
    private int partySize;
    private List<Character> partyMembers;
    private List<Character> aliveMembers;


    public Party(String name, List<Character> party) {
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

    public List<Character> getAliveMembers() {
        return aliveMembers;
    }

    public void setAliveMembers(List<Character> aliveMembers) {
        this.aliveMembers = aliveMembers;
    }

    public void updateAliveMember(Character updatedMember, int index) {
        this.aliveMembers.set(index, updatedMember);
    }

    public int getPartyMaxSize() {
        return partySize;
    }

    public void removeAliveMember(){
        List<Character> temp = new ArrayList<>();
        for (Character character : aliveMembers)
        {
            if (character.isAlive())
                temp.add(character);
        }
        aliveMembers = temp;
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



    public List<Character> generateRandomParty(int partySize) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getMemberFromList(int index) {
        return partyMembers.get(index);
    }

    public List<Character> getPartyMembers() {
        return partyMembers;

    }


}
